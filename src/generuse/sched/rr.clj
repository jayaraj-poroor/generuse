;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.

(ns generuse.sched.rr
   (:gen-class)
   (:use [generuse.exec	:only (eval-pre-condition src-str)])      
)

(defn sched-init[cmd-param exec]
	{:pre [(instance? clojure.lang.Ref (:sched-data exec))]}	
	(dosync 
		(ref-set (:sched-data exec) 
				 { 	:sched-max (Long/parseLong cmd-param)
				 	:sched-idx (atom 0)
				 	:sched-count (atom 0)
				 }
		)
	)
)

(defn sched-done[exec]
	(if (<= @(:sched-count @(:sched-data exec)) 
		      (:sched-max @(:sched-data exec))
		)
		false
		true
    )
)

(defn sched-usecase[exec]	
	(swap! (:sched-count @(:sched-data exec)) inc)
	(when (<= @(:sched-count @(:sched-data exec)) 
			   (:sched-max @(:sched-data exec))
		  )
		(let [  bin			(:bin exec)
				usecases 	(:usecases bin)
				n-usecases 	(count usecases)
				sched-idx 	(:sched-idx   @(:sched-data exec))
				sched-count	(:sched-count @(:sched-data exec))				
			 ]
			(loop [idx @sched-idx iter 0]
				(if (= iter n-usecases)
					nil
					(let [ 	usecase (usecases idx)
							e (eval-pre-condition usecase exec)
						]
						(if (true? e)
							(do
								(reset! sched-idx (mod (inc idx) n-usecases))
								(usecases idx)
							)
							(do
								(when 	(not (or (true? e) (false? e) ))
										(println "Precondition for usecase: "
												  (:name usecase)
											   "returned a non-boolean result: "
												  e
												  " at: " 
												  (src-str (:src usecase))
										)
								)
								(recur (mod (+ idx 1) n-usecases) (+ iter 1))
							)
						)
					)
				)
			)
		)
	)
)
