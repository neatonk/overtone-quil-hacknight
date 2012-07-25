(ns overtone-quil-hacknight.controller
  (:use [overtone-quil-hacknight.synth]
        [overtone.studio.mixer :only [boot-server-and-mixer]]
        [overtone.sc.node :only [ctl]]
        [quil.core]))

(def state* (atom {:x 0 :y 0 :on? false}))
(def synth* (atom nil))

(def notes (cycle [35 40 41 78 25 27 28]))
(def wob (cycle [1 2 3 4 6 8]))

(defn start-synth
  [] (when-not @synth*
       (boot-server-and-mixer)
       (reset! synth* (dub-bass))))

(defn setup []
  (smooth)         ;;Turn on anti-aliasing
  (frame-rate 15)  ;;Set framerate to 5 FPS
  (background 0))  ;;Set the background color

(defn draw []
  (let [{:keys [x y on?]} @state*]
    (stroke 255)
    (stroke-weight 255)
    (fill 255 0 0 0.6)
    (background 0)
    (when on?
      (ellipse x y 10 10))))

(defn mouse-pressed
  [] (let [x (mouse-x)
           y (mouse-y)
           w (width)
           h (height)]
       (ctl @synth*
            :note (nth notes (long x))
            :pos (- (/ x (* 0.5 w)) 1)
            :wob-freq (nth wob (long x)))
       (reset! state* {:x x :y y :on? true})))

(defn mouse-released
  [] (let [x (mouse-x)
           y (mouse-y)]
       (reset! state* {:x x :y y :on? false})))

(defn- sketch-window
  "Get the window containing our sketch."
  [sk]
  (-> sk meta :target-obj deref))

(defn- show-sketch
  "Show the sketch."
  [sk]
  (-> sk sketch-window (.setVisible true)))

(defn controller
  "Launch the controller"
  []
  (start-synth)
  (show-sketch
   (sketch
    :title "Controller"  ;;Set the title of the sketch
    :setup setup         ;;Specify the setup fn
    :draw draw           ;;Specify the draw fn
    :mouse-clicked mouse-pressed
    :mouse-dragged mouse-pressed
    :mouse-pressed mouse-pressed
    :mose-released mouse-released
    :size [323 200])))

(comment
  (start-synth)
  (controller)

  )
