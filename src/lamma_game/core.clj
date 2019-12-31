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

(defn get-deck [unshuffled-deck]
  (shuffle unshuffled-deck))

(defn draw-card [deck]
  (let [updated-deck (pop deck)
        drawn-card (first deck)]
    (hash-map :deck updated-deck :card drawn-card)))

(defstruct player :deck :score)

;; (struct player "eggplant" "pizza")

(defn has-won [person]
  (if (count (:deck person) 0) true
      false))

(defn discard [card discard]
  (conj discard card))

(defn discard-from-hand [card hand]
  ;; ensure the hand contains the card
  (do
    (some {card} hand)
    (remove {card} hand)))

(defn discard-from-player [card person]
  (let [hand (:deck person)]
    (discard-from-hand card hand)))

(defn count-points [hand]
  (reduce + hand))

(defn count-person-points [person]
  (let [hand (:deck person)]
    (count-points hand)))

(defn get-hand-from-player [person]
  (:deck person))

(defn get-all-hands [players]
  (map get-hand-from-player players))

(defn count-cards-in-hand [hand]
  (count hand))

(defn count-all-cards [players]
  (let [hands (map get-hand-from-player players)
        counts (map count-cards-in-hand hands)]
    counts))

(def cards-per-player 6)

(defn get-current-player [discard players]
  (let [card-count (count-all-cards players)
        discard-count (count discard)
        number-of-players (count players)
        starting-card-count (* cards-per-player number-of-players)
        current-card-count (+ card-count discard-count)
        total-turns (- starting-card-count current-card-count)
        current-player-number (% total-turns number-of-players)]
    current-player-number))












