(defn sum-proper-divisors [n]
  (let [divisors (filter #(zero? (mod n %)) (range 2 (Math/sqrt n)))]
    (reduce + 1 (concat (map #(/ n %) divisors) divisors))))

(defn get-amicable [n]
  (let [a (sum-proper-divisors n)]
    (if (= n (sum-proper-divisors a))
      a
      0)))

(defn amicable-nums [upto]
  (loop [all #{} current (dec upto)]
    (if (zero? current)
      (do
        (println all)
        (reduce + all))
      (let [a (get-amicable current)]
        (if (or (= current a) (zero? a))
          (recur all (dec current))
          (recur (conj all a current) (dec current)))))))

(amicable-nums 10000)
