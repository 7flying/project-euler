; Answer 1
(def lattice-path
  (memoize
   (fn [ngrid mgrid]
     (cond (and (zero? ngrid) (zero? mgrid)) 1
           (or (< ngrid 0) (< mgrid 0)) 0
           :else (+ (lattice-path (dec ngrid) mgrid) (lattice-path ngrid (dec mgrid)))))))

(lattice-path 20 20)
; TODO: review memoize
