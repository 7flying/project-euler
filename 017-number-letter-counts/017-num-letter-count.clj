; Function taken from: https://clojuredocs.org/clojure.core/partial
; TODO: explain/review Common Lisp's format function
(def to-english
  (partial clojure.pprint/cl-format nil "~@(~@[~R~]~^ ~A.~)"))

(defn hyphen->space [word]
  (clojure.string/replace word #"-" " "))

(defn remove-spaces [word]
  (clojure.string/replace word #" " ""))

(defn num-letter-count []
  ; We have to add 3 words per 'and', from every number from X01 to X99, being
  ; X 1-9
  (+ (reduce * [99 9 3])
     (reduce + (map count (map #(remove-spaces (hyphen->space (to-english %)))
                               (range 1 1001))))))
(num-letter-count)

