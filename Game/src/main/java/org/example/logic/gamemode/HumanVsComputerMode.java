package org.example.logic.gamemode;

import org.example.logic.core.GameSession;
import org.example.players.types.ComputerPlayer;

/**
 * Implements the game mode where a human player competes against the computer.
 * Extends the GameSession class to handle player setup and the welcome message.
 */
public class HumanVsComputerMode extends GameSession {
    /**
     * Provides a welcome message specific to the Human vs. Computer game mode.
     * @return The welcome message as a string.
     */
    @Override
    protected String getWelcomeMessage() {
        return "Welcome to the Duo game!\n";
    }

    /**
     * Sets up the players for the game.
     * The first player is a human, and the second player is initialized as a computer player.
     */
    @Override
    protected void setupPlayers() {
        super.setupPlayers();
        // Converts the second player to a ComputerPlayer using the assigned character
        secondPlayer = new ComputerPlayer(2, secondPlayer.getCharacterEnum());
    }
}

