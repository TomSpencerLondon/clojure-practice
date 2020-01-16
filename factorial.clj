; Will throw overflow exception for n greater
; than 20 because * only accepts and returns long values.

(defn factorial [n]
     (if (= n 0) 1
         (* n (factorial (dec n)))))

; Uses arbitrary precision math function, so works for n greater than 20.
; On my system, (factorial 11439) triggers stack overflow.
; (This will vary from system to system.)
(defn factorial-bigint [n]
     (if (= n 0) 1
         ; the function *' returns arbitrary precision numbers (clojure.lang.BigInt)
         (*' n (factorial-bigint (dec n)))))


(defn factorial-bigint-loop [n]
           (if (= n 0) 1
               (loop [val n i n]
                   (if (<= i 1) val
                       (recur (*' val (dec i)) (dec i))))))


(factorial 4)