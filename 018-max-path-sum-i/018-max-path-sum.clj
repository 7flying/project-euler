(use 'clojure.java.io)
(use '[clojure.string :only (split)])

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(def triangle
  (loop [triangle [] lines (get-lines "../resources/018-triangle.txt")]
    (if (empty? lines)
      triangle
      (recur (conj triangle
                   (into [] (doall (map #(Integer/parseInt %) (split (first lines) #"\s+")))) )
             (rest lines)))))

(defn add-max-nums-to-row [from to]
  (loop [newrow []
         old to
         sum (first (vector (map #(reduce max %) (partition 2 1 from))))]
    (if (empty? old)
      newrow
      (recur (conj newrow (+ (first old) (first sum))) (rest old) (rest sum)))))

(defn max-path-sum []
  (loop [tri (reverse triangle)]
    (if (= (count tri) 1)
      tri
      (recur (conj (rest (rest tri)) (add-max-nums-to-row (first tri) (first (rest tri))))))))

(max-path-sum)

