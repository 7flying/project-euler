(use '[clojure.string :only (split)])

(defn get-name-score [name]
  (reduce + (map #(- (int %) 64) name)))

(defn person-names []
  (let [names (sort (split (slurp "../resources/022_names.txt") #","))]
    names))

(defn names-scores []
  (loop [names (person-names) pos 1 total 0]
    (if (empty? names)
      total
      (recur (rest names) (inc pos) (+ total (* pos (get-name-score (first names))))))))

(names-scores)

