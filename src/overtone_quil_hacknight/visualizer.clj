(ns overtone-quil-hacknight.visualizer
  (:use [overtone-quil-hacknight synth tap]
        [overtone.studio.mixer :only [boot-server-and-mixer]]
        [quil.core]))

(def
  ^:private
  ^:dynamic
  *taps* nil)

;; start tapping the main stereo output bus.
(defn init-taps
  [] (when-not *taps*
       (boot-server-and-mixer)
       (alter-var-root (var *taps*)
                       (constantly (:taps (tapper))))))

(defn get-taps
  "Deref and return all of our taps as a plain old map."
  [] (when *taps*
       (into {} (map (fn [[k v]] [k @v]) *taps*))))

(defn- scale-in
  "Scale a tap value by 'max'."
  [taps key max]
  (abs (* (get taps key 0) max)))

(defn setup []
  (smooth)          ;;Turn on anti-aliasing
  (frame-rate 10)    ;;Set framerate to 5 FPS
  (background 0)) ;;Set the background color

(defn draw []
  (let [taps (get-taps)]
    (stroke (scale-in taps :phase 255))
    (stroke-weight (scale-in taps :phase 10))
    (fill (color (scale-in taps :left 255)
                 (scale-in taps :right 255)
                 (scale-in taps :phase 255)))

    (background 0 0.01) ;; fade out
    (let [diam (+ (scale-in taps :left 100)
                  (scale-in taps :right 100)
                  10)
          x    (scale-in taps :left (width))
          y    (scale-in taps :right (height))]
      (ellipse x y diam diam))))

(defn- sketch-window
  "Get the window containing our sketch."
  [sk]
  (-> sk meta :target-obj deref))

(defn- show-sketch
  "Show the sketch."
  [sk]
  (-> sk sketch-window (.setVisible true)))

(defn visualizer
  "Launch the visualizer"
  []
  (init-taps)
  (show-sketch
   (sketch
    :title "Visualizer"  ;;Set the title of the sketch
    :setup setup         ;;Specify the setup fn
    :draw draw           ;;Specify the draw fn
    :size [323 200])))

(comment
  (visualizer)
  )
