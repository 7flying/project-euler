(use 'clojure.java.io)
(use '[clojure.string :only (split)])

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(def triangle
  (loop [triangle [] lines (get-lines "resources/018-triangle.txt")]
    (if (empty? lines)
      triangle
      (recur (conj triangle
                   (map #(Integer/parseInt %) (split (first lines) #"\s+")))
             (rest lines)))))

triangle
(reverse triangle)

(partition 2 1 [1 2 3 4 5 6 7 8 9 10 11 12 13 14])
(map #(apply max %) (partition 2 1 [1 2 3 4 5 6 7 8 9 10 11 12 13 14]))
