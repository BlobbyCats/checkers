# Checkers

This is a Java Swing project for an AP CSA (Computer Science A) class. The project implements a Checkers game, allowing players to play against each other on a graphical user interface.

## Getting Started

To run the Checkers game, make sure you have Java Development Kit (JDK) installed on your system. You can download the latest version of JDK from the Oracle website or any other trusted source.

### Clone the Repository
git clone https://github.com/BlobbyCat/checkers.git

### Compile and Run

1. Navigate to the project directory:
2. Compile the Java source files using javac *.java
3. Run the Checkers game: java CheckersDriver


## How to Play

1. Launch the Checkers game by following the instructions in the "Getting Started" section.

2. The game will open in a graphical user interface.

3. The game follows the standard rules of Checkers. Each player takes turns moving their pieces diagonally on the board. 

4. To make a move, click on one of your pieces to select it. Valid moves for that piece will be highlighted. Click on the desired destination to move the piece.

5. If you have the option to capture an opponent's piece, the valid capturing moves will be shown. Click on the desired destination to capture the opponent's piece.

6. The game continues until one player has captured all of the opponent's pieces or the game ends in a draw or resignation.

7. Enjoy playing! More game instructions can be found when pressing on the Rules button when opening up the GUI.

## Features

- Graphical user interface built using Java Swing.
- Interactive gameplay with mouse clicks for piece selection and movement.
- Highlighting of valid moves and capturing moves.
- Support for two-player checkers game.

## File Structure

- `CheckersDriver.java`: The driver class for the program.
- `Board.java`: Represents the game board and handles the logic of piece movement and capturing.
- `Colors.java`: Hosts the specific RGB values used for coloring in the game.
- `Player.java`: Represents a player in the game.
- `HomePage.java`: Handles the game's homescreen.
- `HomePageBkgd.java`: Sets background color for the homescreen
- `GameScreen.java`: Handles the game's in progress screen.
- `FinalScreen.java`: Handles the game's ending screen.
- `Rule.java`: Holds the rules of the game.
- `Move.java`: Contains methods involving piece movement.

## Contributing

Contributions to the project are welcome. If you find any issues or have suggestions for improvement, please feel free to open an issue or submit a pull request. Have fun playing!


