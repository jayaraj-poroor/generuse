;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.

(ns generuse.run
   (:gen-class :main true)
   (:use [generuse.gss-parser 	:only (parse-and-translate-gss)])
   (:use [generuse.gso-parser 	:only (parse-and-translate-gso)])   
   (:use [generuse.exec 		:only (do-exec print-exceptinfo)]) 
   (:use [generuse.bin 			:only (import-bins)])    
   (:use [bultitude.core 		:as   b])
   (:use clojure.pprint) 
   (:use clojure.tools.cli) 
   (:require [clojure.string :as str]
   			 [generuse.log :as log]
   )
   (:use clojure.test)
   (:import	(clojure.lang IPersistentMap) (java.io File))
)

(def cli-opts
  ;; An option with a required argument
  [["-g" "--gss PATH" "System specification file path"
    :default nil
   ]
   ["-t" "--term" "Terminal output. Disables cumulus logging."
    :default false
   ]
   ["-j" "--gso PATH" "Object specification file path"
    :default nil
   ]
   ["-c" "--cfg PATH" "Configuration file path"
    :default "./generuse.cfg"
   ]   
   ["-s" "--sched SCHEDULER" "Usecase scheduler algorithm"
    :default "rr"
   ]
   ["-r" "--sched-param SCHED-PARAM" "Usecase scheduler param"
    :default "3"
   ]
   ["-p" "--paths \"PATH ...\"" "Paths to search gss files"
    :parse-fn #(if 	(.startsWith % "\"") 
    				(str/split (subs % 1 (dec (count %))) #"\s")
    				[%]
    		   )
    :default ["."]
   ]                     
   ["-x" "--import-depth MAX-DEPTH" "Maximum import depth"
    :parse-fn #(Long/parseLong %)
    :default 10
   ]                        
   ["-h" "--help"]
   ]
)

(def sched-functions #{"sched-usecase" "sched-init" "sched-done"})

(defn resolve-sched [alg]
	(let [ns (some	#(when (= (str %) (str "generuse.sched." alg)) %)
					(b/namespaces-on-classpath 
						:prefix "generuse.sched"
						:classpath (System/getProperty "java.class.path")
					)
			 )
		 ]
		 (when ns
	 		(use ns :reload-all)
	 		(apply merge
		 		(map 
			 		#(hash-map (keyword %) @(resolve %))
			 		(filter	
			 			#(and (function? @(resolve %))		 		 
			 			     (contains? sched-functions (str %))
			 			 ) 
			 			(keys (ns-publics ns))
			 		)
		 		)
	 		)
		 )
	)
)

(defn load-and-exec [gss-path gso-path sched-alg sched-cmd-param 
					 import-depth paths cfg log-ch]
	(try
		(let [bin		(parse-and-translate-gss gss-path)
		  	  heap		(parse-and-translate-gso gso-path)
		  	  heap-ref 	(ref heap)
		  	  combin 	(import-bins paths import-depth bin)
		 	 ]
			(let [sched-fns (resolve-sched sched-alg)]
				(if (= (count sched-fns) (count sched-functions))
					(do-exec combin heap-ref sched-fns sched-cmd-param cfg log-ch)
					(println (str "Specified scheduling algorithm: " 
								  sched-alg 
								  " is not [fully] implemented. "
								  "Expecting to find functions: "
								  (str/join "," sched-functions)
								  ". Found: "
								  (str/join "," sched-fns)								  
							  )
					)
				)
				;(println @heap-ref)
			)
		)
		(catch clojure.lang.ExceptionInfo e 
			(print-exceptinfo e nil)
		)
		(catch Throwable e 
			(.printStackTrace e) 
		)
	)
)

(defn do-main [args]
	(try
		(let [cmd (parse-opts args cli-opts)
			  options (:options cmd)
			  errors  (:errors  cmd)
			]
			(cond 
				errors					
					(println errors)
				(not (:gss options)) 
					(println "Give main GSS file path as argument.")
				(not (:gso options)) 
					(println "Give GSO file path as argument.")
				(not (.exists (File. (:gss options))))
					(println "GSS file: " (:gss options) " does not exist.")
				(not (.exists (File. (:gso options))))
					(println "GSO file: " (:gso options) " does not exist.")																					
				(not (.exists (File. (:cfg options))))
					(println "Configuration file: " (:cfg options) 
							 " does not exist." )
				:else
					(do 
						(def cfg-path (:cfg options))
						(def cfg (load-string (str "(quote " (slurp cfg-path) ")")))
						(def log-ch (log/init cfg (:term options)))
						(load-and-exec 
							(:gss options) 
							(:gso options) 
							(:sched options)
							(:sched-param options)
							(:import-depth options)
							(:paths options)
							cfg
							log-ch
						)
						(Thread/sleep 10000); enough time for flushing events
					)
			)
		)
		(catch Throwable e
			(.printStackTrace e)
		)
	)
)

(defn -main[& args]
	(do-main args)
)