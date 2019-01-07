# showing off:

**author:** tado-mi

**date:**   Aug 2018

**use:**    free. credit when due is encouraged and appreciated

# general:

included is a package of Java source code files for a little visual Chaos, metamorphosed from code found here: [Lines18](https://github.com/tado-mi/Lines18).

// brought to you from the creators 'a nerd is procrastinating'

# what is happening:

An arbitrarily large grid is created and is gradually filled with randomly generated *n* balls of the same color. Once *m* balls are aligned horizontally, vertically or diagonally, they are erased, where *n* and *m* are a function of the dimensions of the grid. If all the randomly added have resulted in a score, the color of the balls on the grid changes.</br>

Essentially, the code is playing a monochromatic version of [Lines98](https://www.lines98.com/)/Lines18 with itself. Interestingly enough, some patterns can be observed and predictions made about the behaviour of the system.

# included files:

## Chaos.java

The bones and the muscles of the endevour. Details can be found in the original Lines18 readme and code.

The non-trivial change is the addition of Timer, which simply calls the **add()** method, and the rest is largely handled as if it was the original game.

## ChaosGUI.java

Simply visualises the grid of Chaos.
 
## main.java

Simply initialises an instance of Chaos with the parameters provided on the command line.

## makefile:

Some magic for your convinience. For more information, see [here](https://www.cs.swarthmore.edu/~newhall/unixhelp/javamakefiles.html).

## compiling:

hit on the terminal:
    
    make
    java main -size -width -height

note: -size / -width / -height need to be replaced with actual numbers.
or:

	make samplerun

to free your computer from the bytes occupied by the .class:

    make clean

# other

shall such desire be felt, feel free to report bugs/suggestions/questions to tadouchiha@gmail.com

It is possible that there are variables floating around that aren't used - a legacy from the original game, although I tried clean all up.
