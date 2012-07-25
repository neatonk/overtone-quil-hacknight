(defproject overtone-quil-hacknight "0.0.1-SNAPSHOT"
  :description "Overtone + Quil examples."
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [overtone "0.7.1"]
                 [quil "1.6.0"]]
  :main ^{:skip-aot true} overtone-quil-hacknight.core
  :repl-init overtone-quil-hacknight.core)
