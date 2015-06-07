(defn cycle-size [deno]
  (loop [nume 1 cy '()]
    (if (some #{(mod nume deno)} cy)
      (count cy)
      (recur (* 10 (mod nume deno)) (conj cy (mod nume deno))))))

(defn largest-reciprocal-cycle []
  (loop [n 999 largest 0 deno 999]
    (if (= 0 n)
      (list largest deno)
      (if (> (cycle-size n) largest)
        (recur (dec n) (cycle-size n) n)
        (recur (dec n) largest deno)))))

(largest-reciprocal-cycle)
