package org.example.logic.core;

import java.util.Arrays;

public class Game {
    // Array representing the Tic-Tac-Toe board with each position labeled 1-9 initially
    private final String[] board;

    /**
     * Initializes a new game board with default position values (1 to 9).
     * Each position is represented as a string of its index for easy selection.
     */
    public Game() {
        board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }

    /**
     * Initializes a game board with a pre-defined board state.
     * @param board An array representing the current state of the board.
     */
    public Game(String[] board) {
        this.board = board;
    }

    /**
     * Draws board on screen
     * @param boardData All data, regarding placing of characters on board
     */
    public static void drawBoard(String[] boardData) {
        System.out.printf("""
                          %s | %s | %s
                        ------------
                          %s | %s | %s
                        ------------
                          %s | %s | %s
                                        %n""",
                boardData[0], boardData[1], boardData[2],
                boardData[3], boardData[4], boardData[5],
                boardData[6], boardData[7], boardData[8]);
    }

    /**
     * Register move on the board
     * @param position Position on the board that the player wants to take
     * @param character Character which take place on the board
     * @return Status of operation (success/fail)
     */
    public boolean registerMove(int position, String character) {
        if (position < 0 || position > 8 || !isValidMove(position)) {
            return false;
        }
        board[position] = character;
        return true;
    }

    /**
     * Checks whether the submitted position is in the range from 1 to 9
     * @param position Position on the board that the player wants to take
     * @return Confirmation that the submitted position is within the specified limits
     */
    public boolean isValidMove(int position) {
        return board[position].matches("[1-9]");
    }

    /**
     * Check if the game ended in a victory for one of the players
     * @return Describes whether the game ended in a victory for one of the players (Yes/No)
     */
    public boolean isWinEnd() {

        // Check rows
        for (int row = 0; row <= 6; row += 3) {
            if (board[row].equals(board[row + 1]) && board[row + 1].equals(board[row + 2])) {
                return true;
            }
        }
        // Check columns
        for (int column = 0; column <= 2; column++) {
            if (board[column].equals(board[column + 3]) && board[column + 3].equals(board[column + 6])) {
                return true;
            }
        }

        // Check diagonals
        return (board[0].equals(board[4]) && board[4].equals(board[8])) ||
               (board[2].equals(board[4]) && board[4].equals(board[6]));
    }

    /**
     * Check if there are no more free positions on the board to move to
     * @return Describing whether there are no more free positions on the board to move to
     */
    public boolean isBoardFull() {
        return Arrays.stream(board).noneMatch(cell -> cell.matches("[1-9]"));
    }

    /**
     *
     * @return An array containing all the values of positions on the board
     */
    public String[] getBoard() {
        return board;
    }

    /**
     * Used for implementing computer logic
     * @return Copy of array containing all the values of positions on the board
     */
    public Game cloneGame() {
        return new Game(this.board.clone());
    }

}
