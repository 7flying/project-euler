; Answer 1: derive a formula to obtain the corners
; 7 8 9
; 6   2
; 5 4 3
;
; Starting at level 0, level n has 2n + 1 numbers, to obtain 1001 numbers
; we need 500 levels
; Top-right number: (2n + 1)^2
; Top-left number: (2n + 1)^2 - 2n
; Bottom-left number: (2n + 1)^2 - 4n
; Bottom-right number: (2n + 1)^2 - 6n

(defn number-spiral-diagonals []
  (inc (reduce + (for [a (range 1 501)] (- (* 4 (* (inc (* 2 a)) (inc (* 2 a))))
                                           (* 12 a))))))

(number-spiral-diagonals)



