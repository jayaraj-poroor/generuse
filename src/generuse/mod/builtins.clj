;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.

(ns generuse.mod.builtins
   	(:gen-class)
   	(:require [clojure.set :as set])
   	(:require [clojure.string :as str])
   	(:use clojure.stacktrace)
   	(:use clojure.tools.trace)
   	(:use [generuse.lib.exec :only (deref-eval defaxon is-basic-type?)])   	
   	(:import	(clojure.lang IPersistentMap)
	)
)

(defaxon :any ["let"]	
	target-eval
)

(defaxon :any ["copy"]	
	(deref-eval target-eval)
)

(defaxon :boolean ["must-be" "is"]	
	(let [target (deref-eval target-eval)]
		(if (= (:action ctx) "must-be")
			(assoc target :pass (target :value))
			target
		)
	)
)

(defaxon :any ["log"]	
	(do
		(def target (deref-eval target-eval))
		(def value (if (= (:type target) :map) target (:value target)))
		(def value (if (= (class value) clojure.lang.LazySeq)
			           (str "(" (str/join " " value) ")")
			           value
				   )
		) 
		(println value)
		target-eval
	)
)

(defaxon :any ["to_:string"]	
	(let [target (deref-eval target-eval)
		  value   (:value target)
		  value   (if value value target) ;to support :map evals and like
		 ]
		 {:value (str value) :type :string}		 
	)
)

(defaxon :string ["ends"]
	(let [value 		(:value (deref-eval target-eval))
		  with-value 	(:value (deref-eval (:with param-evals)))
		 ]
		 (if (and (string? value) (.endsWith value with-value))
			 {
			 	:value true
			 	:type  Boolean
			 }
		 	{
		 		:value false
		 		:type  Boolean
		 	}
		 )
	)
)

(defaxon :any ["update!"]	
	(let [param (:with param-evals)
		  val   (:value (deref-eval param))
		 ]
		 (do
			(when 	(and (= (:type target-eval) :heap-obj)
						 param
					)
					(dosync 
							(alter 	(:value target-eval) 
									assoc 
									:value 
									val
							) 
					) 
			)
			target-eval
		)
	)
)

(defaxon :integer ["wait-millis"]	
	(try
		(Thread/sleep (:value (deref-eval target-eval)))

		{
			:value true
			:type  Boolean
		}

		(catch Exception e
			{
				:value false
				:type Boolean
			}
		)
	)
)

(defn is-matching-eval? [_eval param-evals]
	(let [obj       (deref-eval _eval)
		  eval-type (:type obj)
		  matches?  (fn [[param-name param-eval]]
						(let [param-value 	(:value (deref-eval param-eval))]
							 (= (:value (obj param-name)) param-value)
						)		  	
		  	        )
		 ]
		 (if param-evals
			(condp = (:type obj)
				:map
				(every? 
					matches?
					param-evals
				)
				(when (is-basic-type? eval-type)
					  (= (:value obj) (:value (deref-eval (:with param-evals))) )
				)
			)
			true
		)
	)
)

(defaxon :seq ["count"]	
	(let [seq-value (:value (deref-eval target-eval))]
		{
			:type Long
			:value
			(reduce
				#(+ %1 (if (is-matching-eval? %2 param-evals) 1 0) )
				0
				seq-value
			)
		}
	)
)

(defaxon :seq ["pick"]	
	(let [seq-value (:value (deref-eval target-eval))]
		{
			:type :seq
			:mode "strict"
			:value
			(filter
				#(is-matching-eval? % param-evals)
				seq-value
			)
		}
	)
)

(defaxon :nil ["pick"]
	{:type :nil :value nil}
)

(defaxon :nil ["count"]
	{:type Long :value 0}
)