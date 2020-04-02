#BattleShipGame
# The project is built on back of Gradle version 4 and above.

# Windows Setup 
----------------

#Run the game from:
   GameRunner.java on your IDE.
# Change the file name in case you want to try out various scenarios
# Some samples are present under src/
  drawgame.txt
  valid.txt
  invalidFile

Unix:
------

#To run from the command line:
#To download all the dependencies and build the Jar and run tests.
bin/setup

#To run the program along:
bin/battleship_game

Remember to change the file name in the main program to try out various scenarious 

#Design considerations:
----------------------
	The input is considered 
	Q 1 1 A1 B2 C3

	where Q is type of ship
	1 & 1 are its width and height

	A1 is the coordinate for Player 1 
	B2 is the coordinate for Player 2 
	C3 is the coordinate for Player 1(in case of 2 player).

Logic is 
(position%NumberOfPlayers)

#No playing strategy provided , so the game always defaults to DefaultPlayingStrategy



#Libraries:
------------
Mockito for testing
Lombok






