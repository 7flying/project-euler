; Answer 1
(defn next-collatz [n]
  (if (even? n)
    (/ n 2)
    (inc (* 3 n))))

(defn collatz-sequence [n]
  (loop [next n steps 1]
    (if (= next 1)
      steps
      (recur (next-collatz next) (inc steps)))))

(loop [number 1 max-steps 0 max-number 0]
  (if (= number 1000000)
    (list max-number max-steps)
    (let [steps (collatz-sequence number)]
      (if (> steps max-steps)
        (recur (inc number) steps number)
        (recur (inc number) max-steps max-number)))))

; A more elegant way
(apply max-key second (map #(list % (collatz-sequence %)) (range 1 1000000)))
