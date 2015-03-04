; Answer 1
(defn sum-multiples-3-5
  "Returns the sum of all the multiples of 3 or 5 below a given number."
  [number]
  (loop [current 1 sum 0]
   ;(println (str "Current: " current " Sum: " sum))
    (if (= current number)
      sum
      (if (or (= (mod current 3) 0) (= (mod current 5) 0))
        (let [sum (+ sum current)] 
          (recur (inc current) sum))
        (recur (inc current) sum)))))

(sum-multiples-3-5 1000)
