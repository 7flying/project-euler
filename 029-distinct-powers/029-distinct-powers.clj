(defn power [base exponent]
  (bigint (reduce *' (repeat exponent base))))

(defn distinct-powers []
  (count (into #{} (for [a (range 2 101) b (range 2 101)] (power (bigint a) b)))))

(distinct-powers-two)
