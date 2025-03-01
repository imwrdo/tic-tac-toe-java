package org.example.logic.gamemode;

import org.example.logic.core.GameSession;

/**
 * Implements the game mode where a human player competes against the other human.
 * Extends the GameSession class to handle welcome message.
 */
public class HumanVsHumanMode extends GameSession {
    /**
     * Provides a welcome message specific to the Human vs. Human game mode.
     * @return The welcome message as a string.
     */
    @Override
    protected String getWelcomeMessage() {
        return "Welcome to the Single game!\n";
    }

}
