; Answer 1
(def power-two
  (iterate (partial * 2) 1N))

(defn digits-of-n [n]
  (map #(Integer/parseInt (str %)) (seq (str n))))

(reduce + (first (map digits-of-n (drop 1000 (take 1001 power-two)))))
