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

(defn quadratic-prime [a b n]
  (+ (* n n) (* a n) b))

(defn max-prime-sec [a b]
  (loop [n 0 total 0]
    (if (is-prime? (quadratic-prime a b n))
      (recur (inc n) (inc total))
      total)))

(defn greatest-quadratic-primes []
  (loop [combi (for [x (range -1000 1000) y (range -1000 1000)] [x y])
         greatest 0 coefss []]
    (if (empty? combi)
      coefss
      (let [tem (max-prime-sec (first (first combi)) (second (first combi)))]
        (if (> tem greatest)
          (recur (rest combi) tem (first combi))
          (recur (rest combi) greatest coefss))))))

(greatest-quadratic-primes)
