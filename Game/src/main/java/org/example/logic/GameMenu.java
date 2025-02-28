package org.example.logic;

import org.example.logic.gamemode.HumanVsComputerMode;
import org.example.logic.gamemode.HumanVsHumanMode;

import java.util.Scanner;

public class GameMenu {
    private static final Scanner SCANNER = new Scanner(System.in);

    // Game start point
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

    // Display the menu options
    public void displayMenu() {
        StringBuilder menuText = new StringBuilder();
        menuText.append("\nMenu:\n")
                .append("Please select game mode:\n")
                .append("1 - Human vs. Human\n")
                .append("2 - Human vs. Computer\n")
                .append("3 - Exit");

        System.out.println(menuText);
    }

    // Get user input for menu choice
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
