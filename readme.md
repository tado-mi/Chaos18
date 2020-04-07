# Chaos 18

Code written by [tado-mi](github.com/tado-mi) in August 2018. This repository is a package of Java source code files for a little visual Chaos, metamorphosed from code found here: [Lines 18](https://github.com/tado-mi/lines-18). Brought to you from the creators `a nerd is procrastinating`.

An arbitrarily large grid is created and is gradually filled with randomly generated `n` balls of the same color. Once `m` balls are aligned horizontally, vertically or diagonally, they are erased, where `n` and `m` are a function of the dimensions of the grid. If all the randomly added have resulted in a score, the color of the balls on the grid changes.

Essentially, the code is playing a monochromatic version of [Lines 98](https://www.lines98.com/) with itself. Interestingly enough, some patterns can be observed and predictions made about the behaviour of the system.

It is possible that there are unused variables floating around. Those would be a legacy from the original game. I might end up fixing that sometime.

# Files:

## Chaos.java

The bones and the muscles of the endeavour. Details can be found [here](https://github.com/tado-mi/lines-18).

The non-trivial change is the addition of a `Timer`, which simply calls the `add()` method, and the rest is largely handled as if it was the original game.

## ChaosGUI.java

Simple visualizer the grid of Chaos.

# Running

There is a (rudimentary) `makefile` included for your (and our) convenience. After compilation, use the command:

    java main < size > < width > < height >

and replace `size`, `width` and `height` with integers. `size` is the size of the balls on the screen; `width` and `height` are the dimensions. Game parameters will be calculated automatically.

Or use `make samplerun` command.
