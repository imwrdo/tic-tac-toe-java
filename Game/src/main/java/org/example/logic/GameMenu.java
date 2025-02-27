package org.example.logic;

import java.util.Scanner;

public class GameMenu {
    private static final Scanner scanner = new Scanner(System.in);

    // Game start point
    public void beginGame() {
        boolean isRunning = true;

        System.out.println("Welcome to the Tic-Tac-Toe game!\n");
        while (isRunning) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1 -> new GameModeLogic().beginDuoGame();
                case 2 -> new GameModeLogic().beginSingleGame();
                case 3 -> isRunning = false;
                default -> System.out.println("Invalid choice");
            }
        }

    }

    // Just show menu XD
    public void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("Please select game mode:");
        System.out.println("1 - Human vs. Human\n2 - Human vs. Computer\n3 - Exit");
    }

    // User choice validation
    public int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Your choice must be a number between 1 and 3!");
            return 0;
        }
    }
}

