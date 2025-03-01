# Tic-Tac-Toe in Java

A command-line implementation of the classic Tic-Tac-Toe game written in Java.

## Features

- Two game modes:
    - Human vs Human
    - Human vs Computer
- Simple command-line interface
- Computer player with strategic moves
- Input validation
- Interactive game board display

## Requirements

- Java 23 or higher


## How to Play

1. Start the game and choose a game mode:
    - 1 for Human vs Human
    - 2 for Human vs Computer
    - 3 to Exit

2. The board is numbered from 1 to 9:
```
  1 | 2 | 3  
------------
  4 | 5 | 6  
------------
  7 | 8 | 9  
```

3. Players take turns entering a number (1-9) to place their mark (X or O)
4. First player to get three in a row (horizontally, vertically, or diagonally) wins!

## Project Structure

```
src
└── org.example
    ├── enums
    │    └── Character.java - Enum representing the characters used in the game
    ├── logic
    │    ├── core
    │    │    ├── Game.java - Initializes a new game
    │    │    ├── GameProcessLogicHandler.java - Handles the game loop logic
    │    │    └── GameSession.java - Starts the game session by setting up players, and starting the game loop.
    │    ├── gamemode
    │    │    ├── HumanVsComputerMode.java - Implements the Human vs. Computer game mode.
    │    │    └── HumanVsHumanMode.java - Implements the Human vs. Human game mode
    │    └── menu
    │         └── GameMenu.java - Manages the main menu and game mode selection
    ├── players
    │    ├── types
    │    │    ├── Player.java - Represents a Human player
    │    │    └── ComputerPlayer.java - Represents a Computer player
    │    └── creator
    │         └── PlayerCreator.java - Handles the creation of a Player
    └── Main.java - You know what it is
   

```

## Technical Details

- Built with Java 23
- Implements basic AI strategy for computer moves
- Object-oriented design with clear separation of concerns

