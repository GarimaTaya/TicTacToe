# TicTacToe
This is a simple implementation of the classic Tic Tac Toe game in Java using Swing. The game allows two players to take turns marking the spaces in a 3x3 grid to make a row, column, or diagonal of their symbol (either "X" or "O").

# How to Run
To run the game, simply compile the TicTacToe.java file and execute the generated .class file. You can do this using the following commands in your terminal or command prompt:

-> javac TicTacToe.java

-> java TicTacToe

# Gameplay
Upon running the game, a window titled "Tic Tac Toe" will appear. The game window consists of a 3x3 grid where players can click on the squares to place their symbols.
The game starts with Player 1. Players take turns clicking on an empty square to place their symbol. The first player to get three of their symbols in a row (horizontally, vertically, or diagonally) wins the game. If all squares are filled and no player has three in a row, the game ends in a draw.

# Controls
Click on an empty square in the grid to place your symbol.
If a player tries to click on a square that is already occupied or the game has ended, an alert will be shown, and no action will be taken.

# Features
Visual cues for player turns and game status are provided through messages displayed at the top of the game window.
A "RESET" button is available at the bottom of the window to reset the game at any time.
Sound effects accompany placing symbols and announcing the winner.

# Development Environment
This game was developed using Java and the Swing library for GUI components.
