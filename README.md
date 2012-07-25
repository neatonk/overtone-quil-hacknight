overtone-quil-hacknight
=======================

Repo for Chicago Clojure: [Overtone][over] + [Quil][quil] Hacknight

[over]: https://github.com/overtone/overtone
[quil]: https://github.com/quil/quil

Getting Started
===============

1. Install [lein2][0]
2. Fork and clone this repo ([fork-a-repo][1])
3. Run the examples (`lein run`)
4. Start a repl (`lein repl` or `M-x clojure-jack-in`)
5. Hack!!!

The Examples
============

Visualizer
----------

Draws the colorful circles in response to Overtone's output using the
new `tap` feature. Make some sound and watch see what happens.


Controller
----------

Draws an empty window on the screen and wires it up to a nice dub-bass
synth. Click and drag in the window to control the synth. When you
click, you'll see a target letting you know where you left off.

Running the Examples
====================

```sh
$ cd overtone-quil-hacknight
$ lein run
```

This will run the visualzer and the controller examples at the same
time in different windows and start the dub-bass. Jump in and start
playing with the controller window and watch the visualization.

Stuff you can do
================

* Make the visualization more draw different shapes
* Add a :freq tap and use it to change the background color.
* Make the controller more visual! Change the shape/size/color of
  controller 'target'
* Extend the visualizer/controller to work with a different synth or
  set of taps (it's currently hard coded).

Next Steps
==========


Download the [mini-beast][3] (reccomended!)
-------------------------------------------

Once you've got the beast running you can use your laptop keyboard
to play it (no MIDI keyboard required!)

If you find something that's not working try to fix it and send a
pull-request.


Port [dancer.js][4] to Clojure w/ Overtone + Quil.
---------------------------------------------------------------

This could take some time, but the work has already begun...

*   Check out the original javascript [demo][5].
*   Use [this gist][6] as a starting point.
*   Push your code to a new repo on github.
*   Join the discussion [here][7] and share your work.

[0]: https://github.com/technomancy/leiningen/#installation
[1]: https://help.github.com/articles/fork-a-repo
[2]: https://github.com/technomancy/leiningen/#basic-usage
[3]: https://github.com/overtone/mini-beast#mini-beast
[4]: http://github.com/jsantell/dancer.js/
[5]: http://jsantell.github.com/dancer.js/
[6]: https://gist.github.com/2885724
[7]: https://groups.google.com/d/topic/overtone/8o6OyFAbzGQ/discussion
