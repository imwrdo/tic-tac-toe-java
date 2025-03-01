package org.example;

import org.example.logic.menu.GameMenu;

/**
 * Entry point for the Tic-Tac-Toe application.
 * Initializes the game menu and starts the game loop.
 */
public class Main {

    /**
     * Main method to launch the application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of GameMenu and start the game
        GameMenu gameMenu = new GameMenu();
        gameMenu.beginGame();
    }
}