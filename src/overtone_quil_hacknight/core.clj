(ns overtone-quil-hacknight.core
  (:require [overtone-quil-hacknight.visualizer :as v]
            [overtone-quil-hacknight.controller :as c]))

(defn -main
  "Launch the visualizer and controller"
  [& args]
  ;;(use 'overtone.live)
  (c/controller)
  (v/visualizer))

(comment
  (use 'overtone.live)
  (-main)
  )
