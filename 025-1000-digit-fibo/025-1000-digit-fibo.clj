(defn fibs []
  (map first (iterate (fn [[n m]] [m (+' n m)]) [0 1])))

(take 1 (drop-while #(< (count (str (nth % 1))) 1000)
                    (map-indexed vector (fibs))))
