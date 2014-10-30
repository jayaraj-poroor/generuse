;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.

(ns generuse.log
   (:gen-class)
   (:require [clojure.string :as str]
			 [clj-http.client :as http]
			 [clojure.data.json :as json]		
			 [clojure.core.async :as async :refer [go <! >! <!! >!!]]			     	
   )
)

(def log-ch-limit 50)
(defn init[cfg, disable-cumulus?]
	(def url (get-in cfg [:cumulus :url]))
	(def proxy-info (get-in cfg [:cumulus :proxy]))
	(def url (str url "/stream/generuse/test?cumulus-cap=letmein"))
	(def log-ch (async/chan log-ch-limit))
	(go  
		(loop [msg (<! log-ch)]
			(when msg
				(def data {:event (:event msg) 
						   :usecase {:name (get-in msg [:usecase :name])
						   			 :attribs (get-in msg [:usecase :attribs])
						            }
						   :execid (:execid msg)
						  }
			 	)
				(def req-json {:data data})
				(def req-json-s (json/write-str req-json))
				(when (not disable-cumulus?)
					;(println "http req json: " req-json-s)
					(def req {:body req-json-s
							  :headers {"Content-Type" "application/json"}
						 	}
					)
					(def req-with-proxy (merge req proxy-info))
					(def h (http/post url req-with-proxy))
					;(println "http response: " h)
				)
				(recur (<! log-ch))
			)
			(when (not msg)
				(println "event channel closed.")
			)
		)
	)
	log-ch
)


;proxy auth:
;{:proxy-host "127.0.0.1" :proxy-port 9000 :proxy-user "myuser" :proxy-pass "mypass"}