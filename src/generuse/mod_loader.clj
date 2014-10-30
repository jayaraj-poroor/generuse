;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.

(ns generuse.mod-loader
   (:gen-class)
   (:use [bultitude.core 		:as   b])
   (:use [cemerick.pomegranate :only (add-dependencies)])      
   (:use clojure.pprint) 
   (:use clojure.tools.cli) 
   (:require [clojure.string :as str])
   (:use clojure.test)
   (:import	(clojure.lang IPersistentMap) (java.io File))   
)


(defn load-mod-syms []
   (let [mod-nses (b/namespaces-on-classpath 
                        :prefix "generuse.mod"
                        :classpath (System/getProperty "java.class.path")
                  )
         mod-nses (distinct (concat 
                            mod-nses 
                            (b/namespaces-on-classpath :prefix "generuse.mod") )
                  )
         load-syms (fn [ns]
                      (use ns :reload-all)
                      (apply merge
                         (map 
                            #(hash-map (keyword %) %)
                            (filter  
                               #(function? @(resolve %)) 
                               (keys (ns-publics ns))
                            )
                         )
                      )
                   )
       ]
       
       (apply merge 
          (map
            load-syms
            mod-nses
          )
        )
   )
)


(defn collect-axons[axons sym-info]
  (let [ mod-var     (resolve (second sym-info))
         axon-info   (:axon (meta mod-var))
         axon-info   (if axon-info axon-info (:axon (meta @mod-var)))
         names       (:names axon-info)
         target-type  (:target-type axon-info)
        ]
        (if (vector? names)
            (reduce
              #(let [qual-name (if target-type (str target-type "/" %2) %2)]
                  (if (axons qual-name)
                    axons
                    (assoc %1 qual-name {:axon @mod-var})
                  )
                )
              axons
              names
            )
            axons  
        )
  )
)

(defn load-axons[]
   (let [mod-syms (load-mod-syms)
        ]
          (doall
             (reduce
                collect-axons
                {}
                mod-syms
             )
          )
   )
)

(defn add-dynamic-deps[cfg]
      (add-dependencies 
         :coordinates (:dependencies cfg) 
         :repositories (merge cemerick.pomegranate.aether/maven-central
                              {"clojars" "http://clojars.org/repo"}
                        )    
      )
)