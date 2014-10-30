;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.

(ns generuse.exec
   	(:gen-class)
   	(:require [clojure.set :as set])
   	(:require [clojure.string :as str]
			  [clojure.core.async :as async :refer [go <! >!]]
   	)
   	(:use clojure.stacktrace)
   	(:use clojure.tools.trace)
   	(:import	(clojure.lang IPersistentMap)
	)
	(:use generuse.mod-loader)
   	(:use [generuse.lib.exec :only (deref-eval basic-type-keyword 
   		                            is-numeric-type? is-basic-type?)
   	      ]
   	)   	
)

(declare eval-op)
(declare exec-stmt)
(declare exec-usecased)

(def id-state (atom {:last-ts 0 :suffix 0}))
(defn get-id[]
	;(java.util.UUID/randomUUID)
	(let [ts (System/currentTimeMillis)]
		(if (= (@id-state :last-ts) ts)
			(do
				(def new-suffix (unchecked-inc (@id-state :suffix)))
				(swap! id-state assoc :suffix new-suffix)
				(str ts "_" new-suffix)
			)
			(do
				(swap! id-state assoc :last-ts ts :suffix 0)
				(str ts "_0")
			)
		)
	)
)

(defn src-str[^IPersistentMap src]
	{:pre [(not= src nil)]}		
	(let [	start 	(:start src)
			end 	(:end src)
		 ]
		(str (:file start)  ":" (:line start) ":" 	(:pos start) " near " 
													(:text start))
	)
)

(defn eval-pre-condition [usecase exec]	
	(let [pre-cond 	(:pre-cond-stmt usecase)
		  pre-eval 	(when pre-cond  (exec-stmt pre-cond "_pre" usecase exec))
		  r      	(if pre-cond  (:value (deref-eval pre-eval)) true)
		 ]
		 r
	)
)

(defn resolve-seq-obj[seq-obj selector]
	(let [seq-value (seq-obj :value)]
		(condp = selector
			"first"  (first seq-value)
			"second" (second seq-value)
			"last"   (last seq-value)
			(let [n (re-find #"\d+" selector)
				  n (try (Long/parseLong n) (catch NumberFormatException e 0))
				 ]
				(when (< n (count seq-value))
					(nth seq-value n)
				)
			)
		)
	)
)

(defn resolve-obj[obj selector]
	(if (= (obj :type) :seq)
		(resolve-seq-obj obj selector)
		(obj selector)
	)
)

(defn get-supref[locals vname]
	(if (instance? clojure.lang.Ref locals)
		(when @locals 
			  (@locals (str "supref:" vname))
		)
		(when locals (locals (str "supref:" vname)))
	)
)

(defn set-supref[locals vname supref];must be called from a txn
	(when @locals 
		  (alter locals assoc (str "supref:" vname) supref)
	)
)

(defn set-suprefs[locals evals]
	(doall 
		(map
			#(let [vname (first %) _eval (second %)]
				(when (:supref _eval)
					  (set-supref locals 
					  	          vname
					  			  (:supref _eval)
					  )							
				)
			)
			evals
		)
	)	
)

(defn merge-supref[supref objref]
	(if (= (count objref) 0)
		supref
		(into [] (concat supref (subvec objref 1)))
	)
)

(defn get-actual-objref[curr-locals objref]
	(let [supref (get-supref curr-locals (objref 0))]
		(if supref 
			(merge-supref supref objref) 
			objref
		)	
	)
)

(defn eval-objref[objref src block exec]
	{:pre [(not= objref nil) (> (count objref) 0)]}
	(let [	curr-locals (:curr-locals exec)	
			globals 	(:globals exec)		
			heap-obj 	(when @curr-locals (@curr-locals (objref 0)))
			objref      (get-actual-objref curr-locals objref)
			qual-name   (str (:group block) "_" (objref 0))
			heap-obj 	(if (not heap-obj) (@globals qual-name) heap-obj)
			heap-obj 	(if (not heap-obj) (@globals (objref 0)) heap-obj)
			mode		(when heap-obj (:mode @heap-obj))
			n-objrefs  	(count objref)
		]
		(if heap-obj
			(loop [$obj heap-obj idx 1]
				(let [next-obj (when (< idx n-objrefs) 
									(resolve-obj $obj (objref idx)) )
					 ]
					(if (not next-obj)
						(if (and (< idx n-objrefs) 
								 (= mode "strict")
							)
							(throw 	(ex-info (str "Unresolved Object: " 
												  (str/join "'s " objref) ".")
											 {:src src}
									)
							)
							(if (instance? clojure.lang.Ref $obj)
								{:type :heap-obj, 
								 :objref objref, 
								 :subref (subvec objref idx)
								 :supref (subvec objref (dec idx))
								 :value $obj,
								}
								$obj							
							)	
						)
						(recur next-obj (+ idx 1) )
					)
				)
			)

			(throw 	(ex-info (str "Unresolved Object: " 
								  (str/join "'s " objref) ".")
							 {:src src}
					)
			)
		)
	)
)

(def numeric-op-result-type (memoize (fn [t1 t2 op]
		(if (>= (.indexOf ["+" "-" "*" "/" "mod"] op) 0)
			(if (or (= t1 Double) (= t2 Double)) 
				Double 
				(if (or (= t1 clojure.lang.Ratio) (= t2 clojure.lang.Ratio) )
					clojure.lang.Ratio
					Long
				)
			)
			Boolean
		)
	))
)

(def binary-boolean-ops
	{
		"and"	#(and %1 %2)
		"or"	#(or %1 %2)
	}
)

(def binary-string-ops
	{
		"+"		#(str %1 %2)
		"="     #(= (str %1) (str %2))
		"not="  #(not= (str %1) (str %2))
	}
)

(def string-op-result-type
	{
		"+" 	String
		"="     Boolean
		"not="  Boolean
	}
)

(def binary-numeric-ops
	{
		"+" 	#(+ %1 %2)
		"-" 	#(- %1 %2)
		"*" 	#(* %1 %2)
		"/" 	#(/ %1 %2) 
		"mod" 	#(mod %1 %2) 
		"=" 	#(= (float %1) (float %2))
		"not=" 	#(not= (float %1) (float %2))
		">"		#(> %1 %2)
		">="	#(>= %1 %2)		
		"<"		#(< %1 %2)		
		"<="	#(<= %1 %2)				
	}
)

(defn cast-and-eval[op heap-obj-type heap-obj-eval basic-type basic-eval 
					src leval-basic? exec]
 	(let [	axons (:axons exec)
 		    basic-type-kw   (basic-type-keyword basic-type)
 			cast-action  (str heap-obj-type "/" "to_" basic-type-kw)
 			cast-action_ (str "to_" basic-type-kw)
 			axon        (if (axons cast-action) 
 				            (axons cast-action) 
 				            (axons cast-action_)
 				        )
 			axon-fn     (:axon axon)
 			casted-eval (when axon-fn
							 (try (axon-fn heap-obj-eval {} {} (:globals exec))
								 (catch	Exception e 
								   	(throw 
								   	  (ex-info 
								   	  	(str
								   		  "Cast action execution error:" 
								   		  cast-action)
								   		{:cause e, :src src}
								   	  )
								   	)
								 )
						   	   )
 						)
 			leval (if leval-basic? basic-eval casted-eval)
 			reval (if leval-basic? casted-eval basic-eval) 			
 		 ]
 		 (if casted-eval
 		 	(eval-op op leval reval src exec)
			(throw (ex-info (str "Cannot cast object of type " 
								heap-obj-type " to " basic-type)
							{:src src}
					)
			)
 		)
 	)
)

(defn eval-op[op leval reval src exec] ;leval/reval : evaluated expressions
	(let [
			l-type     	(:type leval)
			r-type     	(:type reval)			
			l-value	   	(:value leval)
			r-value	   	(:value reval)			
			l-heap-obj 	(when (= :heap-obj (:type leval)) @(:value leval))
			r-heap-obj 	(when (= :heap-obj (:type reval)) @(:value reval))
			l-heap-obj-type (:type l-heap-obj)
			r-heap-obj-type (:type r-heap-obj)
			l-type 		(if (is-basic-type? l-heap-obj-type) 
							l-heap-obj-type 
							l-type
						)
			r-type 		(if (is-basic-type? r-heap-obj-type) 
							r-heap-obj-type 
							r-type
						)
			l-value		(if (is-basic-type? l-heap-obj-type) 
							(:value l-heap-obj) 
							l-value
						)
			r-value		(if (is-basic-type? r-heap-obj-type) 
							(:value r-heap-obj) 
							r-value
						)
		]
		(cond
			(and (is-numeric-type? l-type) 
				 (is-numeric-type? r-type) )
			(if (binary-numeric-ops op)
				{
					:type  (numeric-op-result-type l-type r-type op)
					:value (try ((binary-numeric-ops op) l-value r-value)
								(catch 	Exception e 
									   	(throw 
									   	  (ex-info 
									   		"Binary numeric operation error." 
									   		{:cause e, :src src}
									   	  )
									   	)
								)
						   )
				}
				(throw 	(ex-info  
							(str "Unsupported operation on numeric type: " 
								 op
							)
							{:src src}
						)
				)
			)

			(and (is-numeric-type? l-type) 
				 (= nil r-value) 
				 (= op "-")
			)
			{:type l-type, :value (- l-value)}			

			(and (= Boolean l-type) (=  Boolean r-type))
			(if (binary-boolean-ops op)
				{
					:type  Boolean
					:value (try ((binary-boolean-ops op) l-value r-value)
								(catch 	Exception e 
									   	(throw 
									   	  (ex-info 
									   		"Binary boolean operation error." 
									   		{:cause e, :src src}
									   	  )
									   	)
								)
						   )
				}
				(throw 	(ex-info  
							(str "Unsupported operation on boolean type: " 
								 op
							)
							{:src src}
						)
				)
			)

			(and (= :heap-obj l-type) (is-basic-type? r-type))
			(cast-and-eval op l-heap-obj-type leval r-type reval src false exec)

			(and (= :heap-obj r-type) (is-basic-type? l-type))
			(cast-and-eval op r-heap-obj-type reval l-type leval src true exec)

			(or (= String l-type) (= String r-type))
			(if (binary-string-ops op)
				{
					:type  (string-op-result-type op)
					:value (try ((binary-string-ops op) l-value r-value)
								(catch 	Exception e 
									   	(throw 
									   	  (ex-info 
									   		"Binary string operation error." 
									   		{:cause e, :src src}
									   	  )
									   	)
								)
						   )
				}
				(throw 	(ex-info  
							(str "Unsupported operation on string type: " 
								 op
							)
							{:src src}
						)
				)
			)

			(and (= l-type Boolean) 
				 (= nil r-value) 
				 (= op "not")
			)
			{:type l-type, :value (not l-value)}

			:else
			(do
				(throw 	(ex-info  (str "Unsupported Operation: "  op 
					                   ", l-type: " l-type ", r-type: " r-type)
									{:src src}
						)
				)
			)
		)
	)
)

(defn eval-expr[expr block exec]
	{:pre [(not= expr nil)]}
	(condp = (:kind expr)
		:objref 	(eval-objref (:value expr) (:src expr) block exec)
		:literal 	{:type (:type expr) :value (:value expr)}
		:op 		(eval-op (:value expr) 	(eval-expr (:lexpr expr) block exec)
										   	(when (:rexpr expr) 
										   		  (eval-expr (:rexpr expr) 
										   		  	          block exec
										   		  )
										   	)
										   	(:src expr)
										   	exec
					)
		(throw 	(ex-info  (str "Unsupported expression kind: " (:kind expr))
							{:src (:src expr)}
				)
		)
	)
)

(defn find-udef-action[action target-eval block exec]
	(let [
			block-name	 (:name block)
			block-group  (:group block)
			action-key 	 (str block-group "_" action)
			udef-actions ((:actions (:bin exec)) action-key)
			udef-action  (some #(do
									(assert (map? (:contexts (:object %))))
									(let [objref-expr
											((:contexts (:object %)) 
											 block-name
											)
										 ]
										 (when 
										 	(= 	(:value objref-expr) 
										 		(:objref target-eval)
										 	)
										 	%
										 )
									)
								) 
								udef-actions
						 )
		]
		udef-action		
	)
)

(defn exec-non-usecase-cmd[cmd actor block exec]
													;returns result eval or nil
	(condp = (:kind cmd)
		:stmt (let [r-eval 
						(exec-stmt (:stmt cmd) actor block exec)
					]
					r-eval
			  ) 
		:period nil
		(throw 	(ex-info  (str "Invalid command kind: " (:kind cmd))
							{:src (:src cmd)}
				)
		)		
	)
)

(defn exec-udef-action[udef-action target-eval param-evals ctx src exec]
	(let [	curr-locals 	 (:curr-locals exec)
			locals-backstack (:locals-backstack exec)
			result (atom nil)
			actual-params    (into #{} (keys param-evals))
		 ]

		 (when (not= actual-params  (:formal-params udef-action))
			(throw 	(ex-info  (str "User-defined action parameters don't match:" 
				                   " Required: " 
				                   (str/join "," (:formal-params udef-action))
				                   " Actual: "  
				                   (str/join "," actual-params) 
				                   " for "
				                   (:name udef-action) )
							{:src src}
					)
			)				 	
		 ) 		 

		;(println "Executing udef-action: " (:name udef-action))
		(when @curr-locals 
			  (dosync (alter locals-backstack conj @curr-locals))
		)		

		(dosync			
			(ref-set curr-locals 
				(doall
					(apply merge
						(map #(hash-map (first %) 
										(if (= (:type (second %)) :heap-obj) 
											(:value (second %)) ;this is a ref
											(ref (second %))
										)
							  ) 
							  param-evals
						)
					)
				)
			)
			(alter curr-locals assoc (:name (:object udef-action)) 
									 (if (= (:type target-eval) :heap-obj) 
										 (:value target-eval) 
										 (ref target-eval)
									 )					
			)
			(set-suprefs curr-locals param-evals)
			(when (:supref target-eval)
				  (set-supref curr-locals 
				  	          (:name (:object udef-action)) 
				  			  (:supref target-eval)
				  )
			) 
		)
		(try
			(let [] 
				(loop [cmd-idx 0]
					(if
						(>= cmd-idx (count (:cmds udef-action))) 
						@result
						(recur
							(do
								(let [r-eval
										(exec-non-usecase-cmd 
											((:cmds udef-action) cmd-idx) 
										    (:actor ctx) udef-action exec
										)
									  ]
									  (when r-eval (reset! result r-eval))
								)
								(inc cmd-idx)							
							)
						)
					)
				)
			) 
			(finally
				(do
					(if (> (count @locals-backstack) 0)
						(dosync 
								(ref-set curr-locals 
										 (first @locals-backstack)
								) 
								(alter locals-backstack pop)
						)
						(dosync (ref-set curr-locals nil))
					)
					@result
				)
			)
		)
	)
)

(defn exec-axon[axons action target-eval param-evals ctx src globals]
 	(try
 		(let [r-eval ((:axon (axons action)) 
 				target-eval param-evals ctx globals)]
 			r-eval
 		)
 		(catch Throwable e
			(throw 	(ex-info  (str "Error executing axon for: " action)
							  {:src src} e
					)
			)		 			
 		)
 	)	
)

(defn exec-action [action target-eval param-evals ctx src block exec]
	(let [target-type (:type (deref-eval target-eval))
		  target-type (if (is-basic-type? target-type) 
		  	              (basic-type-keyword target-type) 
		  	              target-type
		  	          )
		  qual-action (str target-type "/" action)
		  udef-action (when (or (= (:kind block) :usecase)
		  						(= (:kind block) :usecased)
		  						(= (:kind block) :action)
		  					)
		  					(find-udef-action action target-eval block exec)
		  			  )
		  globals	  (:globals exec)
		  axons       (:axons exec)
		 ]
		 (cond 
		 	(false? (:value (deref-eval (get param-evals "if"))));param-evals could be nil
		 	nil

		 	udef-action
		 	(let [r-eval 		 	
		 		(exec-udef-action 
		 				udef-action target-eval param-evals ctx src exec)
		 		]
		 		r-eval
		 	)

		 	(axons qual-action)
		 	(exec-axon axons qual-action target-eval param-evals 
		 			   (assoc ctx :action action) 
		 			   src globals
		 	)

		 	(axons action)
		 	(exec-axon axons action target-eval param-evals 
		 		       (assoc ctx :action action) 
		 		       src globals
		 	)

		 	:else
			(throw 	(ex-info  (str "Unsupported action: " qual-action)
							{:src src}
					)
			)
		 )
	)
)

(defn modify-result-eval [modifier r-eval]
	(if (and (= modifier "not") (= (:type r-eval) Boolean))
		{:type 	Boolean 
		 :value (not  (:value r-eval)) 
		 :pass  (when (:pass r-eval) (not (:pass r-eval)))
		}
		r-eval
	)
)

(defn exec-stmt[stmt actor block exec]
	(let [  curr-locals (:curr-locals exec)
		 	action 		(:action stmt)
		 	target-val 	(eval-expr (:target stmt) block exec)
		  	param-evals (apply merge (map #(hash-map 
		  									  (first %1)
		  									  (eval-expr (second %1) block exec)
		  								   )
		  								   (:params stmt)
		  							 )
		  			  	)
		  	ctx			{
		  				 :action action 
		  				 :actor  actor
		  				}
		 ]
		 (do
		 	;(println "Exec stmt with action " action " obj " (str target-val))
		 	(let [r-eval (exec-action action target-val 
		 						 param-evals ctx 
		 						 (:src stmt) block exec
		 				)
		 		  r-eval (modify-result-eval (:result-modifier stmt) r-eval)
		 		 ]
	 			(when (and (false? (:pass r-eval)) (not (.startsWith actor "_"))
	 				  )
					(throw 	(ex-info  (str "Action did not pass: " action)
									  {:src (:src stmt) :pass false 
									   :reason (:reason r-eval)}
							)
					)		 			
	 			)

		 		(when 	(and (:result-id stmt) r-eval)
		 				(when (curr-locals (:result-id stmt))
							(throw 	(ex-info  
										(str "Attempt to reassign local var: "
											 (:result-id stmt)
										)
											{:src (:src stmt)}
									)
							)		 					
		 				)
		 				(dosync 
		 						(alter 	curr-locals 
		 								assoc 
		 							   	(:result-id stmt) 
		 							   	(if (= (:type r-eval) :heap-obj)
		 							   		(:value r-eval) ;by reference
		 							   		(ref r-eval)
		 							   	)
		 							   	;(ref (deref-eval r-eval))
		 						)
		 						(when (:supref r-eval)
		 							  (set-supref curr-locals 
		 							  			  (:result-id stmt)
		 							  			  (:supref r-eval)
		 							  )
		 						)
		 				)
		 		)
	 			r-eval ; return result
		 	)
		 )
	)
)

(defn exec-state-action[state-action exec]
	(let [	globals			 (:globals exec)
			curr-locals 	 (:curr-locals exec)
			prev-locals      @curr-locals
			locals-backstack (:locals-backstack exec)
			need-set  		 (:needs state-action)
			qual-name		 (str 
							     (:group state-action) "_" (:name state-action)
							 )
			result 			 (atom nil)
		 ]
		(println "Executing state-action: " (:name state-action))
		(when @curr-locals 
			  (dosync (alter locals-backstack conj @curr-locals))
		)
		(dosync			
			(ref-set curr-locals 
				(doall
					(apply merge
						(map #(let [name (first %) heap-obj (second %)]
									(hash-map name heap-obj)
							  )
							  (filter 
							  	#(contains? need-set (first %))
							  	@curr-locals
							  )
						)
					)
				)
			)
			(when prev-locals
				(doall
					(map
						#(let [supref (get-supref prev-locals %)]
							  (when supref
							   		(set-supref curr-locals % supref)
							  )
						 )
						need-set
					)
				)
			)
		)
		(try
			(let [] 
				(loop [cmd-idx 0]
					(if
						(>= cmd-idx (count (:cmds state-action))) 
						true
						(recur
							(do
								(let [r-eval
										(exec-non-usecase-cmd 
											((:cmds state-action) cmd-idx) 
										    "_generuse" state-action exec
										)
									  ]
									  (when r-eval (reset! result r-eval))
								)
								(inc cmd-idx)							
							)
						)
					)
				)
			) 
			(finally
				(do
					(dosync
						(when @result
							(alter curr-locals assoc :value 
											   (:value (deref-eval @result)))
							(alter curr-locals assoc :type  
											   (:type (deref-eval @result)))
						)
						(alter curr-locals assoc :mode "strict")
						(alter globals assoc qual-name (ref @curr-locals))
						(if (> (count @locals-backstack) 0)
								(do
									(ref-set curr-locals 
											 (first @locals-backstack)
									) 
									(alter locals-backstack pop)
								)
								(ref-set curr-locals nil)
						)
						(alter (:captured-states @curr-locals)
							   conj
							   (:name state-action)
						)
					)
				)
			)
		)
	)
)


(defn capture-state[usecase exec]
	(let [  curr-locals (:curr-locals exec)
			ready-set (set (keys @curr-locals))
			states    (:states (:bin exec))
		]
		(doall
			(some
				#(let [state-action (second %) 
					   state-name (first %)
					   need-set (:needs state-action)
					  ]
					(when (and (set/subset? need-set ready-set)
							   (not (empty? need-set))
							   (not (contains? @(:captured-states @curr-locals) 
							   				   state-name
							   		)
							   )
						  )
						(exec-state-action state-action exec)
					)
					false ;go through all
				)
				(when states
					(states (str (:group usecase) "_" (:name usecase)))
				)
			)
		)
	)
)

(defn exec-stmt-cmd[cmd actor-idx usecase exec]
	(capture-state usecase exec) 	;if need set empty: captures at usecase start 
	(exec-stmt 
		(:stmt cmd) 
		((:actors usecase)	actor-idx) 
		usecase						
		exec
	)
	actor-idx	
)

(defn eval-branch-cond [branch-cmd usecase exec]
	{:pre [(not= (:stmt branch-cmd) nil)]}		
	(let [branch-cond (:stmt branch-cmd)
		  branch-eval (when branch-cond 
		  					(exec-stmt branch-cond "_branch" usecase exec)
		  			  )
		  r      	  (when branch-eval
		  					(:value (deref-eval branch-eval))
		  					true
		  			  )
		 ]
		 r
	)
)

(defn set-exec-mode[curr-locals mode]
	(dosync (alter 	curr-locals 
					assoc :exec-mode mode
			)
	)
)

(defn exec-usecase-cmd[cmd actor-idx actor-count usecase exec]
														;returns new actor idx
	(let [curr-locals (:curr-locals exec)]
		(condp = (:exec-mode @curr-locals)
			:skip 
			(condp = (:kind cmd)
				:stmt 	actor-idx
				:do     actor-idx
				:cmd    actor-idx
				:branch (do
							(when (eval-branch-cond cmd usecase exec)
								(set-exec-mode curr-locals :branched)
						    )
						    actor-idx
					    )
				:period actor-idx
				(throw 	(ex-info  (str "Invalid command kind: " (:kind cmd))
									{:src (:src cmd)}
						)
				)		
			)

			:branched
			(condp = (:kind cmd)
				:stmt 	(exec-stmt-cmd cmd actor-idx usecase exec)
				:do     (do (exec-usecased usecase cmd exec) actor-idx)
				:branch (do
							(set-exec-mode curr-locals :stop)
						    actor-idx
					    )
				:period (mod (+ actor-idx 1) actor-count)
				(throw 	(ex-info  (str "Invalid command kind: " (:kind cmd))
									{:src (:src cmd)}
						)
				)		
			)

			:stop
			actor-idx					

			(condp = (:kind cmd)
				:stmt 	(exec-stmt-cmd cmd actor-idx usecase exec)
				:do     (do (exec-usecased usecase cmd exec) actor-idx)
				:branch (do
							(if (eval-branch-cond cmd usecase exec)
								(set-exec-mode curr-locals :branched)
								(set-exec-mode curr-locals :skip)
					    	)
					    	actor-idx
						)
				:period (mod (+ actor-idx 1) actor-count)
				(throw 	(ex-info  (str "Invalid command kind: " (:kind cmd))
									{:src (:src cmd)}
						)
				)		
			)					
		)
	)
)

(defn exec-usecase-cmds[usecase curr-locals locals-backstack exec]
	(try
		(let [actor-count (count (:actors usecase))] 
			(do 
				(assert (> actor-count 0))
				(loop [cmd-idx 0 actor-idx 0]
					(if
						(or (>= cmd-idx (count (:cmds usecase))) 
							(= (:exec-mode @curr-locals) :stop)
						)
						true
						(recur
							(inc cmd-idx)
							(exec-usecase-cmd ((:cmds usecase) cmd-idx) 
									  actor-idx actor-count usecase exec
							)
						)
					)
				)
			)
		) 
		(finally
			(if (> (count @locals-backstack) 0)
				(dosync (ref-set curr-locals (first @locals-backstack)) 
						(alter locals-backstack pop)
				)
				(dosync (ref-set curr-locals nil))
			)
			(when (= (:kind usecase) :usecased)
				(dosync	(alter (:activations exec) disj (:id usecase)))				
			)
		)
	)
)

(defn exec-usecased[parent-usecase cmd exec]
	(let [ 	name 			 (:name cmd)
		    activations      (:activations exec)
			group            (:group parent-usecase)
		    qual-name		 (str group "_" name)
		    usecaseds    	 (:usecaseds (:bin exec))
		    usecased       	 (when usecaseds (usecaseds qual-name))
			curr-locals 	 (:curr-locals exec) 
			locals-backstack (:locals-backstack exec)			
		  	param-evals (when usecased 
		  						(apply merge (map 
		  										#(hash-map 
		  									       	(first %1)
		  									       	(eval-expr (second %1) 
		  									  			 parent-usecase exec
		  									        )
		  								   		)
		  								   		(:params cmd)
		  							 		  )
		  			  			)
		  				)
		  	actual-params      (into #{} (keys param-evals))
		 ]

		 (when (not usecased)
			(throw 	(ex-info  (str "No delegate usecase named: " (:name cmd) 
								   " in group: " group " found.")
							{:src (:src cmd)}
					)
			)		
		 )

		 (when (not= actual-params  (:formal-params usecased))
			(throw 	(ex-info  (str "Delegate usecase parameters don't match: " 
				                   "Required: " 
				                   (str/join "," (:formal-params usecased))
				                   " Actual: "  
				                   (str/join "," actual-params) 
				                   " for "
				                   (:name usecased) )
							{:src (:src cmd)}
					)
			)				 	
		 ) 		 

		 (when (contains? @activations (:id usecased))
			(throw 	(ex-info  (str "Recursion detected for delegate usecase: " 
				                   (:name usecased)  
				              )
							{:src (:src cmd)}
					)
			)		
		 )
		
		;(println "Executing usecased: " (:name usecase))

		(when 	@curr-locals 
				(dosync (alter locals-backstack conj @curr-locals))
		)

		(dosync 
			(alter activations conj (:id usecased))
			(ref-set curr-locals 
				(doall
					(apply merge
						(map #(hash-map (first %) 
										(if (= (:type (second %)) :heap-obj) 
											(:value (second %)) ;this is a ref
											(ref (second %))
										)
							  ) 
							  param-evals
						)
					)
				)
			)			
			(alter curr-locals assoc :captured-states (ref #{}))
			(set-suprefs curr-locals param-evals)
		)
		(exec-usecase-cmds usecased curr-locals locals-backstack exec)
	)
)


(defn exec-usecase[usecase exec]
	(let [ 	curr-locals 	(:curr-locals exec) 
			locals-backstack (:locals-backstack exec)
		 ]
		
		;(println "Executing usecase: " (:name usecase))

		(when 	@curr-locals 
				(dosync (alter locals-backstack conj @curr-locals))
		)

		(dosync (ref-set curr-locals {:captured-states (ref #{}) }))

		(exec-usecase-cmds usecase curr-locals locals-backstack exec)
	)
)

(defn print-exceptinfo [e usecase]
   	(println "Exception: "	(.getMessage e) 
   			 "Cause: "		(-> e ex-data :cause)
   			 (if (-> e ex-data :src) 
   			 	 (str " at: "  (src-str (-> e ex-data :src)))
   			 	 ""
   			 )
   			 (if usecase 
   				(str "Aborting usecase: " (:name usecase))
   				""
   			 )
	)
   	(println "Stacktrace: ")
	(.printStackTrace e)

	(when 	(-> e ex-data :cause) 
		    (println "Caused By: ")
			(.printStackTrace (-> e ex-data :cause))
	)
)

(defn do-exec[bin heap-ref sched-fns sched-cmd-param cfg, log-ch]
	(let [
		  axons (do (add-dynamic-deps cfg) (load-axons))
		  bin   (if (:actions bin) bin (assoc bin :actions {}))
		  bin   (if (:usecases bin) bin (assoc bin :usecases []))
		  bin   (if (:usecaseds bin) bin (assoc bin :usecaseds {}))
		  bin   (if (:states bin) bin (assoc bin :states {}))
		  bin   (if (:formulas bin) bin (assoc bin :formulas {}))

	  	  exec  {
	  	  			:bin bin, 
	  	  			:globals heap-ref, 
	  	  			:sched-data (ref nil)
	  	  			:curr-locals (ref nil)
					:locals-backstack (ref())
					:axons axons
					:activations (ref #{})
					:log log-ch
					:id-ctx (atom {})
	  	  		}
		]	
		
		((:sched-init sched-fns) sched-cmd-param exec)

		(let [usecase (atom nil) ;using atom to avoid extra try catch blocks
			                     ;one when usecase is available and the 
			                     ;other when usecase is not available
		     ]
			(loop [continue true]
				(if (not continue) 
					true
					(recur
						(try
							(def id (get-id))
							(println "sched usecase")
							(reset! usecase nil)
							(reset! usecase	((:sched-usecase sched-fns) 
							 				  exec) )
							(when @usecase  
								(do
									(println "sending log msg")
								    (async/put! log-ch {:usecase @usecase 
								    	                :execid id
								    					:event :usecase-exec})
								    (swap! (:id-ctx exec) assoc :usecase-exec-id id)
									(println "executing usecase " (@usecase :name))
									(exec-usecase @usecase exec)
									(println "usecase done")
								    (async/put! log-ch {:usecase @usecase :execid id 
								    					:event :usecase-done})
								)
							)
							(when @usecase true)
							(catch clojure.lang.ExceptionInfo e 
								(do
									(when @usecase
								    	(async/put! log-ch {:usecase @usecase :execid id
								    						:event :usecase-abort})
								    )
									(print-exceptinfo e @usecase)									
									(not ((:sched-done sched-fns) exec)) ;continue if reqd
								)
							)
							(catch Throwable e 
								(do 
									(when @usecase
									    (async/put! log-ch {:usecase @usecase :execid id
									    					:event :error})
								    )
									(.printStackTrace e) 
									false ;don't continue
								)
							)
						)
					)
				)
			)
		)
	)
)
