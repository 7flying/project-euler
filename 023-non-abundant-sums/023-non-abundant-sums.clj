(defn proper-divisors [n]
  (into (sorted-set)
    (mapcat (fn [x] [x (/ n x)])
            (filter #(zero? (rem n %)) (range 2 (inc (Math/sqrt n)))))))

(defn sum-proper-divisors [n]
  (reduce + 1 (proper-divisors n)))

(defn abundant? [n]
  (> (sum-proper-divisors n) n))

(def abundant-numbers
  (filter abundant? (range 12 28124)))
abundant-numbers

(defn non-abundant-sums []
  (let [abu-sum (reduce + (distinct (for [a abundant-numbers b abundant-numbers
                                          :let [temp (+ a b)]
                                          :when (< temp 28124)]
                                      temp))) 
        noabu-sum (reduce + (range 1 28124))]
    (- noabu-sum abu-sum)))

