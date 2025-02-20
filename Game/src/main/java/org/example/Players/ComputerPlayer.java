package org.example.Players;

import org.example.GameLogic.Game;

public class ComputerPlayer extends Player {
    private final String opponentChar;

    public ComputerPlayer(int id, String character) {
        super(id, character);
        this.opponentChar = character.equals("X") ? "O" : "X";
    }

    public int getBestMove(Game game) {
        int i;
        Game testGame;
        // Try to win
        for(i = 0; i < 9; ++i) {
            if (game.isValidMove(i)) {
                testGame = game.cloneGame();
                testGame.registerMove(i, this.getCharacter());
                if (testGame.checkWin()) {
                    return i;
                }
            }
        }
        //Try to block opponent
        for(i = 0; i < 9; ++i) {
            if (game.isValidMove(i)) {
                testGame = game.cloneGame();
                testGame.registerMove(i, this.opponentChar);
                if (testGame.checkWin()) {
                    return i;
                }
            }
        }

        // Try to take any position
        for(i = 0; i < 9; ++i) {
            if (game.isValidMove(i)) {
                return i;
            }
        }

        return -1;
    }
}
