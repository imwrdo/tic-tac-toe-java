package org.example.players;

import org.example.logic.Game;
import java.util.OptionalInt;

public class ComputerPlayer extends Player {
    private final String opponentChar;

    public ComputerPlayer(int id, String character) {
        super(id, character);
        this.opponentChar = character.equals("X") ? "O" : "X";
    }

    public int getBestMove(Game game) {
        return findWinningMove(game, this.getCharacter())
                .orElseGet(() -> findWinningMove(game, this.opponentChar)
                        .orElseGet(() -> findFirstAvailableMove(game)
                                .orElseThrow(() -> new RuntimeException("Can't find valid move"))));
    }



    private OptionalInt findWinningMove(Game game,String playerChar) {
        for(int position = 0; position < 9; ++position) {
            if (game.isValidMove(position)) {
                Game testGame = game.cloneGame();
                testGame.registerMove(position, playerChar);
                if (testGame.checkWin()) {
                    return OptionalInt.of(position);
                }
            }
        }
        return OptionalInt.empty();
    }

    private OptionalInt findFirstAvailableMove(Game game) {
        for(int position = 0; position < 9; ++position) {
            if (game.isValidMove(position)) {
                return OptionalInt.of(position);
            }
        }
        return OptionalInt.empty();
    }

}
