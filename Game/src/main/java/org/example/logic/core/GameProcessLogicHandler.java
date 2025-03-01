package org.example.logic.core;

import org.example.players.types.ComputerPlayer;
import org.example.players.creator.Player;

import java.util.Scanner;

/**
 * Handles the game loop logic for a Tic-Tac-Toe game, including turn management,
 * input validation, and win/draw condition checks.
 */
public class GameProcessLogicHandler {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Manages a Tic-Tac-Toe game loop, alternating turns between two players,
     * validating moves, updating the board, and determining if a player wins
     * or if the game ends in a draw.
     *
     * @param firstPlayer      The first player object
     * @param secondPlayer     The second player object
     * @param isFirstPlayerTurn Indicates whether it is the first player's turn
     */
    void playGame(Player firstPlayer, Player secondPlayer, boolean isFirstPlayerTurn) {
        Game game = new Game();
        while (true) {
            Game.drawBoard(game.getBoard());
            // Determine the current player based on the turn flag
            Player currentPlayer = isFirstPlayerTurn
                    ? firstPlayer
                    : secondPlayer;
            System.out.println("Player %d's turn (%s)"
                    .formatted(currentPlayer.getId(), currentPlayer.getCharacter()));

            // Get the move position based on whether the player is a human or a computer
            int position = currentPlayer instanceof ComputerPlayer
                    ? ((ComputerPlayer) currentPlayer).getBestMove(game)
                    : getUserMove();

            // Validate and register the move, retry if invalid
            if (!game.registerMove(position, currentPlayer.getCharacter())) {
                System.out.println("You did invalid move");
                continue;
            }

            // Check if the current move results in a win
            if (game.isWinEnd()) {
                Game.drawBoard(game.getBoard());
                System.out.println("Player %d's (%s) wins!"
                        .formatted(currentPlayer.getId(), currentPlayer.getCharacter()));
                break;
            }
            // Check if the board is full, indicating a draw
            if (game.isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            // Switch turns to the other player
            isFirstPlayerTurn = !isFirstPlayerTurn;

        }
    }

    /**
     * Retrieves the move position from the human player via console input.
     * Continuously prompts for input until a valid position is entered.
     *
     * @return The board position as a zero-based index (0-8).
     */
    private int getUserMove() {
        System.out.println("Enter position (1-9):");

        while (true) {
            try {
                int position = Integer.parseInt(SCANNER.nextLine());
                validatePosition(position);
                return position-1;
            } catch (NumberFormatException e) {
                System.out.println("Position must be a number!");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Validates whether the submitted board position is within the acceptable range (1-9).
     * Throws an exception if the position is invalid.
     *
     * @param position The board position entered by the user.
     * @throws IllegalArgumentException if the position is outside the valid range.
     */
    private void validatePosition(int position) {
        if (position < 1 || position > 9) {
            throw new IllegalArgumentException("Invalid position! Please enter a number between 1 and 9.");
        }
    }

}

