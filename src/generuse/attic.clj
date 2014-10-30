(ns generuse.parser
   (:gen-class)
   (:import (org.antlr.v4.runtime ANTLRFileStream CommonTokenStream) 
			(org.generuse.parser GeneruseLexer GeneruseParser)
			(org.hsqldb jdbcDriver)
   			(java.io File FileInputStream)
   			(org.openqa.selenium.firefox FirefoxDriver)
   			(org.openqa.selenium By)   			
   			(org.stringtemplate.v4 ST)
   	)
   (:use clojure.reflect)
   (:use clojure.set)
)

;(def axons
;	{
;		":web_browser/open" {:axon _open_browser}
;		"let"			   	{:axon _let}
;		"update!"			{:axon _update!}
;		"println"			{:axon _println}
;	}
;)


(defn ^{:_param-a "table" :_param-b "html@web"} test-main []
	(let 
		[parser 
			(GeneruseParser.
				(CommonTokenStream. 
					(GeneruseLexer. 
						(ANTLRFileStream. 
							"E:\\clojure-install\\generuse\\test\\data\\todolist.gss" 
						)
					)
				)
			)
		]
		(let [tree (.gss parser) cls (Class/forName "org.hsqldb.jdbcDriver")
			 driver (FirefoxDriver.) 
			 st (.add (ST. "hello <name>") "name" "world") ] 
			 (do     ;(pprint (reflect driver :ancestors true))
			 	     (.get driver "http://localhost:8081/angularjs") (Thread/sleep 5000)
			 		 (println "Class: " (.getAttribute (.findElement driver (By/xpath "//*[@gx-row]" ) ) "class"))
			 		 (println "Ret: " (.executeScript driver "return todopage_todolist_show();" (into-array [])))
			 	     tree)
		)
	)
)

