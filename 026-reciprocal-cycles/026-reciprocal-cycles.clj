(defn cycle-size [deno]
  (loop [nume 1 cy '()]
    (let [res (mod nume deno)]
      (if (some #{res} cy)
        (count cy)
        (recur (* 10 res) (conj cy res))))))

(defn largest-reciprocal-cycle []
  (loop [n 999 largest 0 deno 999]
    (if (= 0 n)
      (list largest deno)
      (let [len (cycle-size n)]
        (if (> len largest)
          (recur (dec n) len n)
          (recur (dec n) largest deno))))))

(largest-reciprocal-cycle)
