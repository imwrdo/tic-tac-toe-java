package org.example.logic;

public class Game {
    private String[] board;

    public Game() {
        board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }

    public static void drawBoard(String[] boardData) {
        System.out.println("  " + boardData[0] + " | "+ boardData[1] + " | " + boardData[2]+ "  ");
        System.out.println("------------");
        System.out.println("  " + boardData[3] + " | "+ boardData[4] + " | " + boardData[5]+ " ");
        System.out.println("------------");
        System.out.println("  " + boardData[6] + " | "+ boardData[7] + " | " + boardData[8] + "  ");
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
        for (int i = 0; i <= 6; i += 3) {
            if (board[i].equals(board[i + 1]) && board[i + 1].equals(board[i + 2])) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i <= 2; i++) {
            if (board[i].equals(board[i + 3]) && board[i + 3].equals(board[i + 6])) {
                return true;
            }
        }
        // Check diagonals
        return (board[0].equals(board[4]) && board[4].equals(board[8])) ||
               (board[2].equals(board[4]) && board[4].equals(board[6]));
    }

    public boolean isBoardFull() {
        for (String cell : board) {
            if (cell.matches("[1-9]")) {
                return false;
            }
        }
        return true;
    }

    public String[] getBoard() {
        return board;
    }

    public Game cloneGame() {
        Game clone = new Game();
        clone.board = this.board.clone();
        return clone;
    }

}
