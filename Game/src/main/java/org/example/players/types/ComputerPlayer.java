package org.example.players.types;

import org.example.enums.Character;
import org.example.logic.core.Game;
import org.example.players.creator.Player;

import java.util.OptionalInt;

/**
 * Represents a computer-controlled player in the game.
 * Extends the Player class to implement automated move selection logic.
 */
public class ComputerPlayer extends Player {

    /**
     * Constructs a ComputerPlayer with a specified ID and character.
     * @param id        The ID of the computer player.
     * @param character The character (X or O) representing the player.
     */
    public ComputerPlayer(int id, Character character) {
        super(id, character);
    }

    /**
     * Retrieves the character of the opponent player.
     * @return The opponent's character as a string.
     */
    private String getOpponentCharacter() {
        return getCharacterEnum() == Character.X
                ? Character.O.getCharacterValue()
                : Character.X.getCharacterValue();
    }

    /**
     * Determines the best move for the computer player by prioritizing winning,
     * blocking an opponent's win, or selecting the first available spot.
     * @param game The current game state.
     * @return The index of the best move on the board.
     */
    public int getBestMove(Game game) {
        return findWinningMove(game, this.getCharacter())
                .orElseGet(() -> findWinningMove(game, this.getOpponentCharacter())
                        .orElseGet(() -> findFirstAvailableMove(game)
                                .orElseThrow(() -> new RuntimeException("Can't find valid move"))));
    }

    /**
     * Searches for a move that will result in an immediate win for the specified player.
     * Simulates each possible move and checks if it leads to a win.
     * @param game       The current game state.
     * @param playerChar The character of the player (X or O).
     * @return An OptionalInt with the winning move index, or empty if none found.
     */
    private OptionalInt findWinningMove(Game game, String playerChar) {
        for(int position = 0; position < 9; ++position) {
            if (game.isValidMove(position)) {
                Game virtualGameSimulation = game.cloneGame();
                virtualGameSimulation.registerMove(position, playerChar);
                if (virtualGameSimulation.isWinEnd()) {
                    return OptionalInt.of(position);
                }
            }
        }
        return OptionalInt.empty();
    }

    /**
     * Finds the first available valid move on the board.
     * @param game The current game state.
     * @return An OptionalInt with the index of the first available move, or empty if none found.
     */

    private OptionalInt findFirstAvailableMove(Game game) {
        for(int position = 0; position < 9; ++position) {
            if (game.isValidMove(position)) {
                return OptionalInt.of(position);
            }
        }
        return OptionalInt.empty();
    }

}
