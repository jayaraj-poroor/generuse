(ns generuse.exec-test
  (:require [clojure.test :refer :all]
            [generuse.exec :refer :all]))

(deftest eval-op-test
  (testing "Expression evaluation."
    (is (= (eval-op "+" {:type :int :value 1} {:type :int :value 2} {}) 
    	   {:type :int :value 3}
    	)
    )
    (is (= (eval-op "+" {:type :heap-obj :heap-obj (ref {:type "int" :value 1})} 
    					{:type :int :value 2} {}) 
    	   {:type :int :value 3}
    	)
    )
    (is (= (eval-op "+" {:type :heap-obj :heap-obj (ref {:type "int" :value 1})} 
    					{:type :heap-obj :heap-obj (ref {:type "int" :value 3})} 
    					{}) 
    	   {:type :int :value 4}
    	)
    )
    (is (= (eval-op "/" {:type :heap-obj :heap-obj (ref {:type "int" :value 1})} 
    					{:type :heap-obj :heap-obj (ref {:type "float" :value 3})} 
    					{}) 
    	   {:type :float :value (/ 1 3)}
    	)
    )    
    (is (= (eval-op "/" {:type :heap-obj :heap-obj (ref {:type "int" :value 1})} 
    					{:type :heap-obj :heap-obj (ref {:type "float" :value 0})} 
    					{}) 
    	   {:type :float :value :inf}
    	)
    )    
  )
)
