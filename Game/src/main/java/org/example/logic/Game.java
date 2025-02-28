package org.example.logic;

import java.util.Arrays;

public class Game {
    private final String[] board;

    public Game() {
        board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }

    public Game(String[] board) {
        this.board = board;
    }
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


    public boolean registerMove(int position, String character) {
        if (position < 0 || position > 8 || !isValidMove(position)) {
            return false;
        }
        board[position] = character;
        return true;
    }

    public boolean isValidMove(int position) {
        return board[position].matches("[1-9]");
    }

    public boolean checkWin() {

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

    public boolean isBoardFull() {
        return Arrays.stream(board).noneMatch(cell -> cell.matches("[1-9]"));
    }


    public String[] getBoard() {
        return board;
    }

    public Game cloneGame() {
        return new Game(this.board.clone());
    }

}
