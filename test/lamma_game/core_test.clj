(ns lamma-game.core-test
  (:require [clojure.test :refer :all]
            [lamma-game.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 0))))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 0))))

(deftest build-deck-test
  (testing "FIXME, I fail."
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

