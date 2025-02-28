package org.example.players;

import org.example.enums.Character;
import org.example.logic.Game;
import java.util.OptionalInt;

public class ComputerPlayer extends Player {

    public ComputerPlayer(int id, Character character) {
        super(id, character);
    }

    private String getOpponentCharacter() {
        return getCharacterEnum() == Character.X ? Character.O.getCharacterValue() : Character.X.getCharacterValue();
    }

    public int getBestMove(Game game) {
        return findWinningMove(game, this.getCharacter())
                .orElseGet(() -> findWinningMove(game, this.getOpponentCharacter())
                        .orElseGet(() -> findFirstAvailableMove(game)
                                .orElseThrow(() -> new RuntimeException("Can't find valid move"))));
    }

    private OptionalInt findWinningMove(Game game, String playerChar) {
        for(int position = 0; position < 9; ++position) {
            if (game.isValidMove(position)) {
                Game virtualGameSimulation = game.cloneGame();
                virtualGameSimulation.registerMove(position, playerChar);
                if (virtualGameSimulation.checkWin()) {
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
