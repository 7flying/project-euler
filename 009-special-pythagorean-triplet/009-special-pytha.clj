; Answer 1
(defn specia-pytha [num]
  (for [a (range 1 num)
        b (range a num)
        c [(- num a b)]]
    (if (= (+ (* a a) (* b b)) (* c c))
      (println (str (* a b c))))))

(specia-pytha 1000)
