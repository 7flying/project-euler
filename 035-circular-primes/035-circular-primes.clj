; Generates all the rotations, not efficient for this problem -> ...mm I'll use
; it after all
(defn generate-rotations [number]
  (loop [number (str number) iterations (dec (count (str number)))
        rotations (conj [] (str number))]
    (if (zero? iterations)
      rotations
      (let [temp (clojure.string/join "" (conj
                                          (into [] (rest (seq number)))
                                          (first (seq number))))]
        (recur temp (dec iterations) (conj rotations temp))))))

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

(defn circular-prime? [number]
  (every? identity (map #(is-prime? (Long/parseLong %))
                        (generate-rotations number))))

(count (into #{} (filter #(circular-prime? %) (range 2 1000000))))
