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

Draws the Overtone logo in a new window and connects it to Overtone's
main output using the new `tap` feature. Make some sound and watch it
go!

TODO: add a usage example.

Controller
----------

Draws a _clickable_ button on the screen and wires it up to a simple
synth. Control the synth by interacting with the button.

Running the Examples
====================

```sh
$ cd overtone-quil-hacknight
$ lein run
``` 

This will run the visualzer and the controller examples at the same
time in different windows. Jump in and start playing with the
controller button to make the visualization react.

Next Steps
==========

Build on the examples...
------------------------

TODO: add some specific tasks here


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
