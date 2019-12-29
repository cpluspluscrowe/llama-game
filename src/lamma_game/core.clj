(ns lamma-game.core)

(defn -main [& args]
  (println "Main works"))

(def unused-deck (list))

(defn build-deck
  ([] (build-deck 1 (list)))
  ([card-number deck]
   (if (= card-number 8) deck
       (let [cards (repeat 8 card-number)
             next-card-number (+ card-number 1)
             built-deck (flatten (conj cards deck))]
         (build-deck next-card-number

                     built-deck)))))

