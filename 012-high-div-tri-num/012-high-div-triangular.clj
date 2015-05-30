; Answer 1
; Arithmetic progression: http://en.wikipedia.org/wiki/Arithmetic_progression
(defn triangular-num [n]
  (/ (* n (inc n)) 2))

(def triangular-numbers
  (map triangular-num (iterate inc 1)))

(defn factor? [num den]
  (zero? (mod num den)))

(defn num-divisors [n]
  (* 2 (count (filter #(factor? n %) (range 1 (inc (int (Math/sqrt n))))))))

(first (drop-while #(< (num-divisors %) 500) triangular-numbers))


