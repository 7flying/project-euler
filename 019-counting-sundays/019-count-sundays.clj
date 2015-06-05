; Answer 1
(import [java.util GregorianCalendar])

(defn get-calendar [year month]
  (doto (GregorianCalendar.)
    (.set GregorianCalendar/YEAR year)
    (.set GregorianCalendar/MONTH month)
    (.set GregorianCalendar/DAY_OF_MONTH 1)))

(defn count-sundays []
  (reduce + (for [year (range 1901 2001) month (range 1 13)]
              (let [calendar (get-calendar year month)]
                (if (= GregorianCalendar/SUNDAY
                       (.get calendar GregorianCalendar/DAY_OF_WEEK))
                  1
                  0)))))

(count-sundays)
