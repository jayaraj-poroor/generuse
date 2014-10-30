;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.

(ns generuse.gss-parser
   (:gen-class)
   (:import (org.antlr.v4.runtime ANTLRFileStream 
   	                              CommonTokenStream
   	                              BaseErrorListener
   	        ) 
			(com.generuse.parser GeneruseLexer GeneruseParser)
			(org.generuse PorterStemmer)
   	)
   (:use clojure.reflect)
   (:use clojure.set)
)

(declare translate-gss)
(declare translate-import)
(declare translate-usecase)
(declare translate-usecased)
(declare translate-state)
(declare translate-action)
(declare translate-formula)
(declare translate-formula-or-action)
(declare translate-object-spec)
(declare translate-stmt)
(declare translate-expr)
(declare translate-objref)
(declare translate-objfield)
(declare translate-literal)
(declare translate-cmd)
(declare strip-quotes)
(declare src-info)
(declare token-info)
(declare translate-attrib-values)
(declare translate-sentence)
(declare translate-param-specs)
(declare translate-formal-params)
(declare translate-id)
(declare translate-action-id)
(declare translate-actors)
(declare translate-action-suffix)
(declare translate-state-spec)
(declare translate-objref-ex)
(declare translate-past-spec)

(def last-id (atom 0))
(def parser-error? (atom false))

(defn translate-gss [gss]
	{:pre [(not= gss nil)]}	
	(let [	group       (translate-id (.id (.groupSpec gss)))
			usecases	(into [] (map (partial translate-usecase group) 
									  (.usecase gss)
								 )
						)
			usecaseds 	(apply  merge
								(map (partial translate-usecased group) 
									 (.usecased gss)
								)
						)
			states	 	(apply 	(partial merge-with merge) 
							   	(map (partial translate-state group) 
									 (.state gss)
								)
						)
			actions		(apply 	(partial merge-with union) 
								(map (partial translate-action group) 
									 (.action gss)
								)
						)
			formulas	(apply  merge (map 	(partial translate-formula group) 
											(.formula gss)
									  )
						)
			datas 		(apply  merge
								(map (partial translate-data group) 
									 (.data gss)
								)
						)			
			imports		(into [] (map translate-import
									  (.importSpec gss)
								  )
						)
		 ]{
		 	:usecases 	usecases,
		 	:usecaseds  usecaseds,
		 	:states		states,
		 	:actions 	actions,
		 	:formulas   formulas,
		 	:imports    imports,
			:src (src-info gss)		 	
		 }
	)
)

(defn translate-import [import-spec]
	{:pre [(not= import-spec nil)]}
	{
		:name (translate-id (.id import-spec))
		:attribs (translate-attrib-values (.attributeValue import-spec))
		:src (src-info import-spec)		
	}
)

(defn translate-data [group data]
	{:pre [(not= data nil)]}
	(let [header  		(.dataHeader usecase)
		  name 			(when header (translate-id (.id header)))
		  qual-name 	(str group "_" name)
		  attribs  		(when header 
		  					(translate-attrib-values (.attributeValue header))
		  				) 
		  cmds (into [] (apply concat (map translate-sentence (.sentence data)) ))
	     ]
		(do 
			{
				qual-name
				{:name 	name, 
				 :kind  :data,
			 	 :id   (swap! last-id inc)					
				 :group group,
			     :attribs attribs, 
			     :cmds cmds
			     :src (src-info data)
			 	}
		 	}
		) 
	)
)

(defn translate-instant-spec[spec]
	{ 	(translate-id (-> spec .usecaseId .id))
		{
			:occurs 	(if (.BEFORE_DIRECTIVE spec) :before :after)		
			:past-spec  (translate-past-spec (.pastSpec spec))
		}
	}
)

(defn translate-state[group state]
	{:pre [(and (not= state nil) (.stateHeader state) )]}	
	(let [header 	(.stateHeader state)
		  spec      (translate-state-spec (.stateSpec header))
		  name   	(str (:occurs spec) " " (:name spec))
		  instants  (apply merge (map translate-instant-spec (.instantSpec spec)))
		  cmds 		(into [] 
		  				  (apply concat (map translate-sentence (.sentence state)) )
		  			)
		  qual-usecase 	(str group "_" usecase)
		  body      {  
		 				:name name
		 				:instants instants
		 				:spec spec
		 				:group group
			 			:id   (swap! last-id inc)
			 			:kind :state
		 				:cmds cmds
						:src (src-info state)
			 			:attribs (translate-attrib-values (.attributeValue header))								
 					} 
		 ]
		 (reduce 
		 	(fn [res usecase-name]
		 		(assoc res (str group "_" usecase-name) {name block})
		 	)  
		 	{} 
		 	(keys instants)
		 )
	)
)

(defn translate-action [group action]
	{:pre [(and (not= action nil) (.actionHeader action) )]}
	(let [	header 			(.actionHeader action)
			name 			(translate-id (.id header))
			action-suffix 	(translate-action-suffix (.actionSuffix header))
			name            (if action-suffix (str name " " action-suffix) name)
			qual-name 		(str group "_" name)
		 ]	
			{qual-name #{(translate-formula-or-action :action
											 group 
											 action 
											 name
											 header
					)}		
		}
	)
)

(defn translate-formula [group formula]
	{:pre [(and (not= formula nil) (.formulaHeader formula) )]}
	(let [	header 	(.formulaHeader formula)
			name 	(translate-id (.id header))
			qual-name (str group "_" name)
		 ]	
			{qual-name 	(translate-formula-or-action :formula 
											 group
											 formula 
											 name
											 header
				  		)		
			}
	)
)

(defn translate-formal-params[params]
	(if params
		(into #{}  (map translate-id (.id params) ) )
		#{}
	)
)

(defn translate-formula-or-action [which group node name header]
	{:pre [(and (not= node nil) (not= header nil) )]}
	(let [
		  formal-params (translate-formal-params (.formalParams header))
		  cmds (into [] (apply concat (map translate-sentence (.sentence node)) ))
	     ]
		(do 
			{:name name, 
			 :kind which,
			 :id   (swap! last-id inc),
			 :group group,
			 :formal-params formal-params, 
		     :cmds cmds,
		     :object (when 	(= which :action) 
		     				(translate-object-spec (.objectSpec node))
		     		 )
		     :src (src-info node)
			 :attribs (translate-attrib-values (.attributeValue header))
		 	}
		) 
	)
)

(defn translate-object-spec [objspec]
	{:pre [(not= objspec nil)]}
	{
		:name (translate-id (.id objspec))
		:contexts (apply merge 
						(map #(hash-map (translate-id (.id %))
										(translate-objref (.objRef %)) 
							  ) 
							  (.contextSpec objspec)
				  		)
				  )
		:src (src-info objspec)
	}
)


(defn translate-usecased [group usecase]
	{:pre [(not= usecase nil)]}
	(let [header  		(.usecasedHeader usecase)
		  formal-params (translate-formal-params (.formalParams header))
		  name 			(when header (translate-id (.id header)))
		  actor-spec 	(.actorSpec usecase)
		  actors  		(translate-actors actor-spec)

		  qual-name 	(str group "_" name)
		  attribs  		(when header 
		  					(translate-attrib-values (.attributeValue header))
		  				) 
		  cmds (into [] (apply concat (map translate-cmd (.command usecase)) ))
	     ]
		(do ;(println  "processing usecased " name)
			{
				qual-name
				{:name 	name, 
				 :kind  :usecased,
				 :actors actors,
			 	 :id   (swap! last-id inc)					
				 :formal-params formal-params,
				 :group group,
			     :attribs attribs, 
			     :cmds cmds
			     :src (src-info usecase)
			 	}
		 	}
		) 
	)
)

(defn translate-actors [actor-spec]
	(vec (map translate-id (.actorId actor-spec)))	
)

(defn translate-usecase [group usecase]
	{:pre [(not= usecase nil)]}
	(let [header  		(.usecaseHeader usecase)
		  pre-cond-spec (.preconditionSpec usecase)
		  actor-spec 	(.actorSpec usecase)
		  actors   		(translate-actors actor-spec)
		  name 			(when header (translate-id (.id header)))
		  attribs  		(when header 
		  					(translate-attrib-values (.attributeValue header))
		  				) 
		  pre-cond-stmt (when pre-cond-spec (translate-stmt 
		  										(.stmt pre-cond-spec)))
		  cmds (into [] (apply concat (map translate-cmd (.command usecase)) ))
	     ]
		(do ;(println  "processing usecase " name)
			{:name name,
			 :id   (swap! last-id inc),
			 :kind :usecase,
			 :group group,
		     :attribs attribs, 
		     :pre-cond-stmt pre-cond-stmt, 
		     :actors actors,
		     :cmds cmds
		     :src (src-info usecase)
		 	}
		) 
	)
)

(defn translate-attrib-values [attrib-values]
	{:pre [(not= attrib-values nil)]}	
	(apply merge (map #(hash-map (translate-id (.id %))
							 	 (strip-quotes (.getText (.STRING %)))
						)   
						attrib-values 
				 )
	)
)

(defn translate-cmd[cmd]
	{:pre [(not= cmd nil)]}	
	(cond
		(.branchSpec cmd) [{:kind :branch, 
							:stmt (when (.stmt (.branchSpec cmd))
										(translate-stmt 
												(.stmt (.branchSpec cmd))
										)
								   )
							:src (src-info cmd)
						  }]
		(.doSpec cmd)[{:kind :do			
							:name (translate-id (.id (.doSpec cmd)))
							:params (translate-param-specs (.doSpec cmd))
							:src (src-info cmd)							
						   }]
		(.sentence cmd) (translate-sentence (.sentence cmd))
	)
)

(defn translate-sentence [sentence]
	{:pre [(not= sentence nil)]}		
	(conj
		(into []
			(map #(do {	:kind :stmt, 
					   	:stmt (translate-stmt %)
					   }
				   ) 
					(.stmt sentence) 
		  	)
	  	)
	  	{:kind :period}
    )	
)

(defn translate-multi-param-spec[block]
	(when (.multiParamSpec  block)
   		(apply merge 
   			(map    #(hash-map 	(translate-id (.id %1))
   								(translate-expr %2)
   					)
   					(.paramName (.multiParamSpec block))
   					(.expr (.multiParamSpec block))
   			) 
   		)
	)	
)

(defn translate-auto-param-spec[block]
	(when (.autoParamSpec block)
		(apply merge
			(map #(let [objrefex 	(translate-objref-ex %)]
					(hash-map (last (:value objref)) objrefex)
				  )
				 (.objRefEx (.autoParamSpec block))
			)
		)
	)	
)

(defn translate-param-specs[block]
	(let [params (translate-multi-param-spec block)
		  params (if (seq params) params (translate-auto-param-spec block))
		 ]
		 params
	)
)

(defn translate-action-suffix [action-suffix]
	(when action-suffix
	      (str 	(.PREPOSITION action-suffix) 
	       		" "
	       		(translate-id  (.id action-suffix))
		  )
	)	
)

(defn translate-past-spec[target past-spec]
	(when before-spec
		(let [target-ref (when 	(.objRef past-spec) 
								(translate-objref (.objRef past-spec))
						 )
			  target-ref (when (= (:value target-ref) ["it"])
			  				   target
			  				   target-ref
			  			 )
			 ]
			{
				:action 	(translate-action-id (.actionId past-spec))
				:target-ref target-ref
				:time-spec  (translate-id (.id (.timeSpec before-spec)))
			}
		)
	)
)

(defn translate-stmt [stmt]
	{:pre [(not= stmt nil)]}
	(let
		[ 
		  action 			(translate-id (.id (.actionId stmt)))
		  action-suffix     (translate-action-suffix (.actionSuffix stmt))
		  action            (if action-suffix (str action " " action-suffix) action)
		  result-modifier 	(when (.auxVerb stmt) 
		  						  (when (.NOT (.auxVerb stmt)) "not")
		  	             	)
		  result-id 		(when (.resultId stmt)  
		  						  (translate-id (.id (.resultId stmt)))
		  					)
		  target 			(when (.expr stmt) (translate-expr (.expr stmt)) )
		  params 			(translate-param-specs stmt)
		  past-spec       	(translate-past-spec target (.pastSpec stmt))
		]
		{:action action, :result-id result-id, :params params, :target target
		 :src (src-info stmt)
		 :result-modifier result-modifier
		 :id   (swap! last-id inc)		
		 :past-spec past-spec
		}
	)
)

(defn translate-state-spec[state-spec]
	(when state-spec
		{
			:occurs 	(if (.BEFORE state-spec) :before :after)
			:name     	(translate-id (.id state-spec))
		}
	)
)

(defn translate-objref-ex[objref-ex]
	(let [objref_ 	 	(translate (.objRef objref-ex))
		  state-spec_ 	(translate-state-spec (.stateSpec objref-ex))
		 ]
		 (merge objref_ state-spec_)
	)
)

(defn translate-expr [expr]
	{:pre [(not= expr nil)]}
	(cond 
		(.objRefEx expr)  (translate-objref-ex (.objRefEx expr))
		(.literal expr) (translate-literal (.literal expr))
		:else (do (assert (.expr expr))
				  (if (.op expr)
				  	{	
					  	:kind :op
					   	:value (.getText (.op expr))
					  	:lexpr (translate-expr (.expr expr 0))
					  	:rexpr (when (.expr expr 1) 
					  				 (translate-expr (.expr expr 1))
					  		    )
					  	:src   (src-info expr)
				  	}
				  	(translate-expr (.expr expr 0))
				   )
			  )
	)
)

(defn translate-literal [literal]
	{:pre [(not= literal nil)]}
	(let 
		[literal-rec
			(cond
				(.TRUE literal) 
					{:kind :literal, :type Boolean, :value true}
				(.FALSE literal) 
					{:kind :literal, :type Boolean, :value false}
				(.INT literal) 
					{:kind :literal, :type Long, 
									 :value (Long/parseLong 
									 			(.getText (.INT literal)))
					}
				(.FLOAT literal) 
					{:kind :literal, :type Double, 
									 :value (Double/parseDouble 
											  	  (.getText (.FLOAT literal)))
					}
				(.STRING literal) 
					{:kind :literal, :type String, 
						             :value (strip-quotes 
						            			  (.getText (.STRING literal)))
					}
			)
		]
		literal-rec ;src-info for literal is probably an overkill
		;(assoc literal-rec :src (src-info literal)) 
	)
)

(defn src-info [node]
	{:pre [(not= node nil)]}		
	{
		:start (token-info (.getStart node))
		:end (token-info (.getStop node))		
	}
)

(defn token-info [token]
	{:pre [(not= token nil)]}
	{
		:file (.getSourceName (.getTokenSource token))
		:char-pos  (.getCharPositionInLine token)
		:line  (.getLine token)
		:text  (.getText token)
	}
)

(defn strip-quotes[s]
	{:pre [(>= (.length s) 2)]}	
	(.substring s 1 (- (.length s) 1) )
)

(defn translate-id[id]
	{:pre [(not= id nil)]}
	(reduce #(str (if (string? %1) %1 (-> %1 WORD getText)) 
		          " " 
		          (-> %2 WORD getText) 
		     )
			 id
	)
)

(defn stem[word]
	(let [stemmer (Stemmer.)]
		(doall
			(map
				(.add stemmer %)
				word
			)
		)
		(.stem stemmer)		
		(.toString stemmer)
	)
)

(defn translate-action-id[action-id]
	{:pre [(not= action-id nil)]}
	(reduce #(str (if (string? %1) %1 (stem (-> %1 WORD getText))) 
		          " " 
		          (stem (-> %2 WORD getText))
		     )
		     (.id action-id)	
	)
)

(defn translate-objref [objref]
	{:pre [(not= objref nil)]}	
	(let [ objid 		(translate-id (.id objref))
		   objref-vec	(apply vector objid (map #(translate-id (.id %))
		   											(.objField objref)))
		 ]
		 {:kind :objref, :value objref-vec, :src (src-info objref)}
	)
)

(defn custom-error-listener[]
	(proxy [BaseErrorListener] []
		(syntaxError [recognizer  offendingSymbol line charPos msg e]
			(println "Syntax error at " line 
					 ":" charPos 
					 " near " (.getText offendingSymbol)
					 ": " msg
			)
			(reset! parser-error? true)
		)
	)
)

(defn parse-and-translate-gss [path]
	(let 
		[parser 
			(GeneruseParser.
				(CommonTokenStream. 
					(GeneruseLexer. 
						(ANTLRFileStream. path)
					)
				)
			)
		]
		(reset! parser-error? false)
		(.removeErrorListeners parser)
		(.addErrorListener parser (custom-error-listener))
		(let [gss 	(.gss parser)
			  bin 	(if @parser-error?
						(throw 	(ex-info "Syntax errors detected. " 
		                   				 {:src {:start {:file path}}}
								)
						)							 			 	
					 	(translate-gss gss)
					)

			 ]
			 bin
		)
	)	
)
