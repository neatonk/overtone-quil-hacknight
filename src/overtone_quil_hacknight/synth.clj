(ns overtone-quil-hacknight.synth
  (:use overtone.core))

;; Define fun synth to make sounds with.
(defcgen detuned-saw
  "A detuned saw wave."
  [freq {:default 40 :expands? true}]
  (:ar (->> freq
            (* [0.99 1.01])
            (saw)
            (apply +))))

(defcgen wobble
  "wobble the the input"
  [in   {:doc "input source to wobble"
         :default 0}
   freq {:doc "wobble frequency"
         :default 1}]
  (:ar (let [sweep (lf-tri freq)
             sweep (lin-exp sweep -1 1 40 3000)]
         (lpf in sweep))))

(defcgen wobble-saw
  "Generate a wobbly, detuned saw wave!"
  [freq     {:doc "Main frequency"
             :default 80}
   wob-freq {:doc "Wobble frequency"
             :default 1.0}]
  (:ar (-> (detuned-saw freq)
           (wobble wob-freq)
           normalizer)))

(defsynth dub-bass
  "Synth bass based on Dan Stowells' Dubstep Synth"
  [note {:doc "midi note value":default 40}
   pos {:doc "pan position" :default 0}
   wob-freq {:doc "wobble frequency" :default 1.0}
   wet-level {:doc "reverb level" :default 0.2}]
  (let [freq (midicps (lag note 0.25))
        wob  (wobble-saw freq wob-freq)
        wob  (+ wob (bpf wob 1500 2))
        wet  (g-verb wob
                     :roomsize 9
                     :revtime 0.7
                     :damping 0.7
                     :drylevel 0)]
    (out 0 (pan2 (+ wob (* wet-level wet))
                 pos))))

(comment
  (def bass (dub-bass))
  (ctl bass :note 60)
  (stop)

  ;notes (cycle [40 41 28 28 28 27 25 35 78])
  ;wob-freqs (cycle [1 6 6 2 1 2 4 8 3 3])
  )
