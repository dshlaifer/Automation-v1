Project: automaton
Aothors: David J. Barnes and Michael Kölling

This project is part of the material of the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling

It is discussed in chapter 7.

27. The same patterns emerge.

28. the fill method in java.util.array is used in the reset method of automaton to initialize or clear the array of cell states.

29. I randomized the starting cell, the pattern changes everytime.

31. using state[i] = (left + center + right) % 2 instead of nextState[i]
then your updating the same array your reading from.

32. You can avoid creating nextState by keeping only the last two old values (left and center) as temporary variables.

35. because each cell looks at three spots left,center,right and each can be 0 or 1
there are 2 * 2 * 2 = 8 possible patterns and for each of those 8 patterns the next state is 0 or 1
2^8 = 256 so there are 256 possible rules not infinite.