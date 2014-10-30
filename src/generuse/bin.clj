;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.

(ns generuse.bin
   	(:gen-class)
   	(:use [generuse.gss-parser 	:only (parse-and-translate-gss)])   	
   	(:require [clojure.set :as set])
   	(:require [clojure.string :as str])
   	(:import	(clojure.lang IPersistentMap) (java.io File))
   	(:use  clojure.java.io)	
   	(:use clojure.tools.trace)   	
)

(defn destruct-qual-name[qual-name]
	(let [fields (str/split qual-name #"_")]
		{
			:group  (first fields)
			:name 	(second fields)
		}
	)
)

(defn find-gss-file [paths import-entry]
	(let [name (:name import-entry) 
		  from ((:attribs import-entry) "from")
		  src  (:src import-entry)		
		 ]
		(if from
			(some #(let [gss-file (as-file (str % File/separator from 
												  File/separator name
												  ".gss"
											)
						  		   )
						]
						(if (.exists gss-file)
							{:file gss-file :src src :name name :from from}
							{:file nil		:src src :name name :from from}
						)
					)
					paths
			)
			(throw 	(ex-info (str "Invalid import entry - no 'from' attribute: " 
				                   name
				             )
							 {:src src}
					)
			)			
		)
	)
)

(defn combine-usecases [usecases1 usecases2]
	(let[ collect-names (fn [usecases] 
		  					(apply merge 
		  					  (map #(hash-map (str (:group %) "_" (:name %) )
		  					  				  (:src %)
		  					  		)
		  					  		usecases
		  					  )
		  					)
		  				)
		  names1		(collect-names usecases1)
		  names2		(collect-names usecases2)
		  name-conflicts (set/intersection (into #{} (keys names1)) 
		  								   (into #{} (keys names2)) 
		  				 )
		  str-conflicts  (fn[s qual-name]
		  					(str s "[" qual-name " in files " 
		  						 " in files "
		  						 (:file (:start (names1 qual-name)))
		  						 " and "
		  						 (:file (:start (names2 qual-name))) "] "
		  					)
		  	             )
		]
		(if (empty? name-conflicts)			
			(into [] (concat usecases1 usecases2))

			(throw 	(ex-info (str "Usecases with same names defined. " 
				                   " Conflicting names (group_name format): "
				                   (reduce str-conflicts "" name-conflicts)
				             )
							 {:src nil}
					)
			)						
		)
	)
)


(defn combine-formulas-or-usecaseds [which map1 map2]
	(let[ qual-names1	(into #{} (keys map1))
		  qual-names2	(into #{} (keys map2))
		  name-conflicts (set/intersection qual-names1 qual-names2)
		  str-conflict   (fn[s qual-name]
		  					(str s "[" qual-name " in files " 
		  						 (:file (:start (:src (map1 qual-name)))) 
		  						 " and "
								 (:file (:start (:src (map2 qual-name))))
		  						 "]"
		  					)
		  				 )
		]
		(if (empty? name-conflicts)			
			(merge map1 map2)

			(throw 	(ex-info (str which " with "
								  "same names defined in. " 
				                   "Conflicting names (group_name format): "
				                   (reduce str-conflict "" name-conflicts)

				             )
							 {:src nil}
					)
			)						
		)
	)
)

(defn combine-states [states1 states2]
	(let[ 
		  accum-entries (fn[usecase accum state-entry] 
		  					(conj accum (str usecase "_" (first state-entry)) )
		  				)
		  flat-name-set	(fn[states] 
		  					(reduce 
								#(set/union %1 
										(reduce 
											(partial accum-entries (first %2)) 
											#{} 
											(second %2)
										)
								) 
								#{} 
								states
							)
						)
		  names1       	(flat-name-set states1)
		  names2       	(flat-name-set states2)		  
		  state-conflicts (set/intersection names1 names2)
		  str-conflict  (fn[s flat-name]
		  					(let[fields (str/split flat-name #"_")
		  						 group   (fields 0)
		  						 usecase (fields 1)		  			
		  						 state   (fields 2)			 
		  						 qual-usecase (str group "_" usecase)
		  						]
		  						(str s "[group="  group
		  							    " usecase=" usecase
		  							    " state=" state 
		  							    " in files "
		  							    (:file (:start (:src 
		  							    		((states1 qual-usecase) state)))
		  							    ) " and "
		  							    (:file (:start (:src 
		  							    		((states2 qual-usecase) state)))
		  							    ) "] "		  							    
		  						)
		  					)
		  				)
		]
		(if (empty? state-conflicts)			
			(merge-with merge states1 states2)

			(throw 	(ex-info (str "States with same usecases/names defined. "
				                   " Conflicting names " 
				                   "(group_usecase_name format): "
				                   (reduce str-conflict "" state-conflicts)

				             )
							 {:src nil}
					)
			)						
		)
	)
)

(defn combine-actions [actions1 actions2]
	(let[ qual-names1	 (into #{} (keys actions1))
		  qual-names2	 (into #{} (keys actions2))
		  name-conflicts (set/intersection qual-names1 qual-names2)

		  get-ctxs		 (fn [actions qual-name]
		  					(let [get_ctx_
		  							(fn [action]
					  				 	(apply merge (map
					  				 		#(hash-map  
					  				 			  {:usecase (first %) 
					  				 			  :objref (:value (second %))
					  				 			  :qual-name qual-name}
					  				 			  (:src (second %))
					  				 		)
					  				 		(:contexts (:object action))
					  				 	))
				  				 	)		  						
		  						]
								(apply merge (map get_ctx_ 
								  			  	  (actions qual-name)
			  				 				  )
			  				 	)
			  				 )
		  				 )
		  ctxs1			 (apply merge
		  						(map (partial get-ctxs actions1) name-conflicts)
	  					 )
		  ctxs2			 (apply merge
		  						(map (partial get-ctxs actions2) name-conflicts)
		  				 )
		  str-conflicts  (fn [s conflict]
		  					(str s "name=" 
		  								(:qual-name conflict) "["
		  								(:usecase conflict) ":"
		  						 		(str/join "'s" (:objref conflict)) "] "
		  						 		" in files: "
		  						 		(:file (:start (ctxs1 conflict))) 
		  						 		" and " 
		  						 		(:file (:start (ctxs2 conflict)))
		  					)
		  	 			 )
		  ctx-conflicts  (set/intersection  (into #{} (keys ctxs1)) 
		  									(into #{} (keys ctxs2))
		  				 )
		]
		(if (empty? ctx-conflicts)			
			(merge-with set/union actions1 actions2)

			(throw 	(ex-info (str 	"User-defined actions with "
								  	"same contexts are defined. " 
				                   	"Conflicting actions and their contexts: "
				                   	(reduce str-conflicts "" ctx-conflicts)

				             )
							 {:src nil}
					)
			)						
		)
	)
)

(defn import-bins[paths import-depth bin]
	(when (<= import-depth 0)
		(throw 	(ex-info "Maximum import depth exceeded." {:src (:src bin)} ) )
	)	

	(let [imports 
			(filter
				#(if (:file %) 
					 true 
					(throw 	(ex-info (str "GSS file being imported not found. " 
						                  " name: " (:name %) 
						                  " from: " (:from %)
						             )
									 {:src (:src %)}
							)
					)							 
				 )
				(map
					(partial find-gss-file paths) 
					(:imports bin)
				)
			)
		bins
			(map
				#(import-bins paths 
							 (dec import-depth)
							 (parse-and-translate-gss 
							 	(.toString (.getAbsolutePath (:file %)))
							 )
				)
				imports
			)
		usecases
			(reduce combine-usecases 
				    (:usecases bin) 
				    (map #(:usecases %) bins)
			)
		usecaseds
			(reduce (partial combine-formulas-or-usecaseds "Delegate usecases")
				    (:usecaseds bin) 
				    (map #(:usecaseds %) bins)
			)

		formulas
			(reduce (partial combine-formulas-or-usecaseds "Formulas")
				    (:formulas bin) 
				    (map #(:formulas %) bins)
			)			

		actions
			(reduce combine-actions
				    (:actions bin) 
				    (map #(:actions %) bins)
			)
		states
			(reduce combine-states
					(:states bin)
					(map #(:states %) bins)
			)

		]
		{
				:usecases 	usecases
				:usecaseds 	usecaseds
				:actions   	actions
				:formulas   formulas
				:states     states
		}
	)
)
