==================
=: Instructions :=
==================

Instructions for the game:
The game is called Minesweeper
This game is one that includes 3 different levels: 1,2,3
When the player uses their mouse to click a cell, it will reveal the cell
If the cell shows a number, this refers to how many mines there are around it
If the cell is empty, it means there are no mines around it
If the cell is a mine, the player will lose and the bottom status states it
If the player right clicks a cell, it will flag the cell as a blue. 
When the cell is flagged, the cell cannot be revealed. 
If the player clicks all the non-mines, then the status shows a win. 
The player can decide to reset the game, or change levels 
Changing the levels reset the game immediately. 
Resetting levels get you back to the default level, no bombs
The player can also decide to save and load their state of game. 
When a player clicks a cell, the score goes up. 
Have fun!

====================
=: Implementation :=
====================

Cell: This class is responsible for keeping record of the blocks,
whether they are revealed or flagged. It also stores 
the neighboring blocks of a cell using a list. 

Empty: This is a subclass of cell where there is a difference in the 
reveal function where when this is revealed, it also 
recursively reveals all neighboring empty blocks.

Number: This is a subclass of cell where there is a difference in the 
appearance, that it draws the number of the mines near it 

Mine: This is a subclass of cell where the different functionalities
are used in different classes regarding the gameplay, where 
if this mine is clicked, then it ends the game. 

Board: This is a class where it is the gameplay of the game itself. 
It allows the users to click on different cells and shows the effects of 
clicking such cells. It is used as a panel that can be added to the GUI. 

RunMinesweeper: This is the class that shows the user the board and other 
aspects of the game. It allows the user to interact with the game settings
given the buttons that show levels and reset, allowing the user to 
choose between different levels and choose to reset the game. 

=====================================
=: Hardships during implementation :=
=====================================

There was a significant stumbling block when I was trying to debug the 
neighbor collection for the program. There was an error where 
I was trying to use recursion in order to recurse through the 
different "empty" blocks to also reveal empty blocks next to them. 

I think that my private state is encapsulated very well. From my standpoint 
at the moment, I do not see myself needing to refactor the code. My design 
does a good job of maintaining the MVC model, with board, minesweeper, 
and runminesweeper. 


========================
=: External Resources :=
========================

I used various java libraries online,
"https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html"
"https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html"
  