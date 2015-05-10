
(defn sum-of-squares [num]
  (apply + (take num (iterate (fn [x] (* x x)) (inc 1)))))

(sum-of-squares 2)
