; Answer 1
(defn is-palindrome? [num]
  (= (str num) (apply str (reverse (str num)))))

(apply max (filter is-palindrome?
                   (for [n (range 100 1000)
                         m (range 100 1000)]
                     (* n m))))
