(def cache {"0" 0 "1" 1 "2" 32 "3" 243 "4" 1024 "5" 3125 "6" 7776 "7" 16807
            "8" 32768 "9" 59049})

(defn number-fifth-power-sum? [num]
  (loop [num num sum 0 origi num]
    (if (zero? num)
      (= origi sum)
      (recur (quot num 10) (+ sum (get cache (str (mod num 10)))) origi))))

(defn digit-fifth-pow []
  (loop [numbers [] current 2]
    (if (= current (* 59049 5))
      numbers
      (if (number-fifth-power-sum? current)
        (recur (conj numbers current) (inc current))
        (recur numbers (inc current))))))

(reduce + (digit-fifth-pow))

; Answer 2: using transients
; Without transients: "Elapsed time: 471.258413 msecs"
; With transients: "Elapsed time: 447.753366 msecs"
; However, in subsequent executions it's not clear
(defn digit-fifth-pow-transient []
  (loop [numbers (transient []) current 2]
    (if (= current (* 59049 5))
      (persistent! numbers)
      (if (number-fifth-power-sum? current)
        (recur (conj! numbers current) (inc current))
        (recur numbers (inc current))))))

(reduce + (digit-fifth-pow-transient))
