; Answer 1
(loop [n 1 m 2 sum 2]
  (if (<= 4000000 (+ n m))
    sum
    (if (even? (+ n m))
      (recur m (+ n m) (+ sum (+ n m)))
      (recur m (+ n m) sum))))

; Answer 2
(defn fibs []
  (map first (iterate (fn [[n m]] [m (+ n m)]) [0 1])))

(apply + (filter even? (take-while #(<= % 4000000) (fibs))))
