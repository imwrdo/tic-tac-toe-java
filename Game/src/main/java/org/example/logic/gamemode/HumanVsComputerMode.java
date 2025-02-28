package org.example.logic.gamemode;

import org.example.logic.GameSession;
import org.example.players.ComputerPlayer;

public class HumanVsComputerMode extends GameSession {
    @Override
    protected String getWelcomeMessage() {
        return "Welcome to the Duo game!\n";
    }

    @Override
    protected void setupPlayers() {
        super.setupPlayers();
        secondPlayer = new ComputerPlayer(2, secondPlayer.getCharacterEnum());
    }
}

