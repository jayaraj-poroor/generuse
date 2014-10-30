;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.

(defproject com.generuse/generuse "0.5.0-SNAPSHOT"
  :description "Generuse: Generative Usecases"
  :url "http://generuse.com"
  :license {:name "Proprietory. Copyright Jayaraj Poroor. All Rights Reserved."
            :url ""}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.antlr/antlr4 "4.1"]
                 ;[org.hsqldb/hsqldb "2.3.1"]
                 [org.clojure/tools.cli "0.3.1"]
                 [com.cemerick/pomegranate "0.2.0"]                   
                 [bultitude "0.1.5"]                                  
                 [org.clojure/tools.trace "0.7.6"]
                 [org.generuse/generuse-lib "0.1.0-SNAPSHOT"]
                 [org.clojure/data.json "0.2.4"]
                 ;[http-kit "2.1.16"] 
                 [clj-http "0.9.0"]                 
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]                 
                ]               
  :java-source-paths ["src/grammar"]
  :main generuse.run
  :aot [generuse.run]
  :repositories {"sonatype-oss-public"
               "https://oss.sonatype.org/content/groups/public/"}  
  )
