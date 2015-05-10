; Answer 1 - Not working...
(loop [n 13195 m 2]
  (if (<= m n)
    (if (= (mod n m) 0)
      (let [n (/ n m)]
        (if (not= n 1)
          (recur n 2)
          (recur n (inc m)))))
    (println "n: " n " m:" m)))

; Answer 2
(defn factor? [num den]
  (zero? (mod num den)))

(defn largest-prime-factor [num]
  (let [limit (long (Math/sqrt num))]
    (loop [n num fac 2]
      (cond
        (> fac limit) n
        (= fac n) n
        (factor? n fac) (recur (/ n fac) fac)
        true (recur n (inc fac))))))
(largest-prime-factor 13195)

