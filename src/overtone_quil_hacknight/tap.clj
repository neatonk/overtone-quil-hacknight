(ns overtone-quil-hacknight.tap
  (:use overtone.core))

;; Define a synth we can use to tap into the stereo out.
(defsynth tapper
  "Tap into a stereo bus. Provides 3 taps: left, right, and phase."
  [bus 0]
  (let [source (in bus 2)
        left (select 0 source)
        right (select 1 source)]
    (tap :left 10 left)
    (tap :right 10 right)
    (tap :phase 10 (- left right))))

(comment
  (def mytaps (:taps (tapper)))
  @(:left mytaps)
  @(:right mytaps)
  @(:phase mytaps)
  )
