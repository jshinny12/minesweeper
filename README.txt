=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: _______
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. Recursion 
  	I initially used a collection, but I switched to recursion. 
  	The recursion was used to reveal empty blocks, and call it recursively for every
  	empty block next to the revealed empty blocks. 
  	
  	The feedback was as such: 
  	You shouldn't need to use Collections for this. 
  	You could just use an int that keeps track of the number of bombs around a square as you recurse around.
  	 If you want the points for Collections, maybe add Undo functionality or something similar?

  2. I/O
  This is used to store previously made game states that allow the games to draw
  any level that is already created. I also used a save and load state in order
  to implement the writing state. 
  
  Feedback:  
  Looks good. Just make sure to have both reading and writing capability.

  3. 2-D arrays
  This is used as the internal game state of a grid-based game. 
  I utilize the array in order to gain cells that are neighboring cell
  such as the way it was done in pennstagram, where the array was used 
  to take an average of neighboring cells. 
  
  There was no feedback for this. 

  4. JUnit
  	For this, I initially chose to do inhertiance/subtyping but after going to office 
  	hours, as with #1, I decided to go with JUnit testing instead. The playable 
  	component of my game is the "minesweeper.java" file, and I used this as a corner
  	to test all of the subclasses of Cell, and different functionalities in 
  	Minesweeper. I also added tests in which I play the game itself without having to actually 
  	open the game. 
  	
  	
	Feedback: This is not a sufficient implementation of inheritance/subtyping
	for the game as you could model the difference between a covered and uncovered cell
	using a boolean or an int. You can indeed create a class for cells but the different
	types of cells would need to have drastically different behavior (like having different types of bombs).
	Generally, you need one method that gets overridden in the various subclasses that has a
	significantly different enough of an implementation. Feel free to followup on Piazza
	if you have questions about this.

  
  

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.

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


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?

There was a significant stumbling block when I was trying to debug the 
neighbor collection for the program. There was an error where 
I was trying to use recursion in order to recurse through the 
different "empty" blocks to also reveal empty blocks next to them. 

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?

I think that my private state is encapsulated very well. From my standpoint 
at the moment, I do not see myself needing to refactor the code. My design 
does a good job of maintaining the MVC model, with board, minesweeper, 
and runminesweeper. 


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.

  I used various java libraries online,
  "https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html"
  "https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html"
  