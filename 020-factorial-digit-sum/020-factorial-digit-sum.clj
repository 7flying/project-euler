(defn factorial [n]
  (reduce *' (range 1 (inc n))))

; Properly include this from #16
(defn digits-of-n [n]
  (map #(Integer/parseInt (str %)) (seq (str n))))

(reduce + (digits-of-n (factorial 100)))
