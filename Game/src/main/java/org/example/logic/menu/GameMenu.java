package org.example.logic.menu;

import org.example.logic.gamemode.HumanVsComputerMode;
import org.example.logic.gamemode.HumanVsHumanMode;

import java.util.Scanner;

/**
 * Manages the main menu and game mode selection for the Tic-Tac-Toe game.
 * Allows players to choose between Human vs. Human, Human vs. Computer, or exit the game.
 */
public class GameMenu {
    // Scanner for reading user input
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Starts the game menu and handles user input for selecting game modes.
     * Continuously displays the menu until the user chooses to exit.
     */
    public void beginGame() {
        boolean isRunning = true;

        System.out.println("Welcome to the Tic-Tac-Toe game!\n");
        while (isRunning) {
            displayMenu();
            try {
                int choice = getUserChoice();
                switch (choice) {
                    case 1 -> new HumanVsHumanMode().startGame();
                    case 2 -> new HumanVsComputerMode().startGame();
                    case 3 -> isRunning = false;
                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                SCANNER.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Displays the menu options to the user.
     * Provides choices for game modes and exiting the application.
     */
    public void displayMenu() {
        StringBuilder menuText = new StringBuilder();
        menuText.append("\nMenu:\n")
                .append("Please select game mode:\n")
                .append("1 - Human vs. Human\n")
                .append("2 - Human vs. Computer\n")
                .append("3 - Exit");

        System.out.println(menuText);
    }

    /**
     * Retrieves and validates the user's menu choice.
     * @return The user's choice as an integer.
     * @throws NumberFormatException if the input is not a valid number.
     */
    public int getUserChoice() throws NumberFormatException {
        while (true) {
            try {
                return Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
