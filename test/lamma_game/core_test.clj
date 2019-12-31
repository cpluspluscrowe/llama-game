(ns lamma-game.core-test
  (:require [clojure.test :refer :all]
            [lamma-game.core :refer :all]))

(deftest build-deck-test
  (testing "Shows that the build-deck function produces a deck with 8 cards for each number"
    (is (=
         (build-deck)
         (map conj
              (flatten (list (repeat 8 1)
                             (repeat 8 2)
                             (repeat 8 3)
                             (repeat 8 4)
                             (repeat 8 5)
                             (repeat 8 6)
                             (repeat 8 7))))))))

(deftest draw-card-test
  (testing "Shows that the build-deck function produces a deck with 8 cards for each number"
    (is (=
         (draw-card (list 1))
         (hash-map :deck (list) :card 1)))))
