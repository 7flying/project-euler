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

(def person-names
  (loop [pnames () lines (get-lines "../resources/022_names.txt")]
    (if (empty? lines)
      pnames
      (recur (conj pnames (into () (split (first lines) #"\s+"))) (rest lines)))))

(slurp "../resources/022_names.txt")
(str (slurp "../resources/022_names.txt"))
