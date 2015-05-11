; Answer 1
(defn sum-of-squares [num]
  (apply + (map (fn [x] (* x x)) (take num (iterate inc 1)))))

(defn square-of-sum [num]
  (let [x (apply + (take num (iterate inc 1)))] 
    (* x x)))

(defn sum-square-difference [num]
  (- (square-of-sum num) (sum-of-squares num)))
