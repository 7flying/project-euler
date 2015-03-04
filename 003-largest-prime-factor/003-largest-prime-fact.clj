; Answer 1
(loop [n 13195 m 2]
  (if (<= m n)
    (if (= (mod n m) 0)
      (let [n (/ n m)]
        (if (not= n 1)
          (recur n 2)
          (recur n (inc m)))))
    (println "n: " n " m:" m)))
