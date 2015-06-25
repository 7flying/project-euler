(def coins [1 2 5 10 50 100 200])

(defn coin-sums []
  (loop [all-coins (rest coins) sums (conj (repeat 200 0) 1)]
    ))
; 
;for coin in coins:
;    for target in range(coin, len(matrix)):
;        matrix[target] += matrix[target - coin]

