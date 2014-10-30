;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.

(ns generuse.gso-parser
   (:gen-class)
   (:import (org.antlr.v4.runtime ANTLRFileStream CommonTokenStream) 
			(org.generuse.parser CSVLexer CSVParser)
   	)
   (:use clojure.set)
   (:use [generuse.gss-parser :only (token-info custom-error-listener)])      
)

(declare strip-csv-quotes)
(def gso-parser-error? (atom false))

(defn src-info-gso [node]
   {:pre [(not= node nil)]}      
   {
      :start (token-info (.getStart node))
   }
)

(defn translate-field[field]
   {:pre [(not= field nil)]} 
   (cond
      (.TEXT field)     (.trim (.getText (.TEXT field)))
      (.STRING field)   (.trim (strip-csv-quotes (.getText (.STRING field)))) 
   )
)

(def default-values
  {
    :boolean true
    :int     0
    :float   0
    :string  ""
  }
)

(def to-clojure-types
  {
    :boolean Boolean
    :int     Long
    :float   Double
    :string  String
  }
)

(def value-parsers
  {
    :boolean #(Boolean/parseBoolean %)
    :int #(Long/parseLong %)
    :float #(Double/parseDouble %)
  }
)

(defn initialize[entry]
   {:pre [(not= entry nil)]} 

   (if   (:value entry)
         (when (value-parsers (:type entry))
               (assoc! entry :value ((value-parsers (:type entry)) (:value entry)) )
         )
         (assoc! entry :value (default-values (:type entry)))
   )

   (when (to-clojure-types (:type entry)) 
         (assoc! entry :type (to-clojure-types (:type entry)))
   )            
   entry
)

(defn translate-row[hdr row]
   (let [fields (.field row) 
         obj-name (translate-field (.get fields (.indexOf hdr "object")))
        ]
      (loop [heap-entry (transient {}) idx (- (.size fields) 1)]
         (if (< idx 0) 
             {obj-name (ref (persistent! (initialize 
                                            (assoc! heap-entry 
                                                    :src 
                                                    (src-info-gso row))
                                            )
                                          )
                        )
             }
             (recur  (assoc! heap-entry 
                             (keyword (hdr idx))
                             (let [f (translate-field (.get fields idx))]
                                (if (= (hdr idx) "type") (keyword f) f) 
                             )
                     )
                     (- idx 1)
             )
         )
      ) 
   )  
)

(defn translate-gso [gso]
   {:pre [(not= gso nil)]}   
   (let [hdr (into [] (map translate-field (.field (.row (.hdr gso)))))
        ]
        (if (>= (.indexOf hdr "object") 0)
            (assoc (apply merge (map (partial translate-row hdr) (.row gso)))
                   :type "heap"
            )
            (do
               (print "Cannot find object header field.")
               {}
            )
        )
   )
)

(defn strip-csv-quotes[s]
   (if   (and (>= (.length s) 2) 
            (= (.charAt s 0) \") 
            (= (.charAt s (- (.length s) 1) ) \") 
         )
         (.replace (.substring s 1 (- (.length s) 1) ) "\"\"" "\"")
         s
   )
)


(defn parse-and-translate-gso [path]
   (let 
      [parser 
         (CSVParser.
            (CommonTokenStream. 
               (CSVLexer. 
                  (ANTLRFileStream. path)
               )
            )
         )
      ]
      (reset! gso-parser-error? false)
      (.removeErrorListeners parser)
      (.addErrorListener parser (custom-error-listener))
      (let [gso   (.file parser)
           heap   (if @gso-parser-error?
                      (throw  (ex-info "Syntax errors detected. " 
                                     {:src {:start {:file path}}}
                             )
                      )                     
                      (translate-gso gso)
                  )

          ]

          heap
      )
   )  
)
