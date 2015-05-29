; Answer 1
; TODO: properly include this function from 007
(defn is-prime? [num]
  (cond
    (<= num 1) true
    (< num 4) true
    (zero? (mod num 2)) false
    (< num 9) true
    (zero? (mod num 3)) false
    :else (let [limit (Math/floor (Math/sqrt num))]
            (loop [b 5]
              (if (<= b limit)
                (cond
                  (zero? (mod num b)) false
                  (zero? (mod num (+ b 2))) false
                  :else (recur (+ b 6)))
                true)))))

(defn sum-primes-below [num]
  (reduce + (take num (filter is-prime? (iterate inc 1)))))

(sum-primes-below 2000000)
