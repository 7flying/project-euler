; fix project cristo
(ns project-euler.core
  (:require [clojure.math.combinatorics :as combo]))

(def lexi-permutations
  (combo/permutations (range 10)))

(first (drop 999999 lexi-permutations))
