package org.example.logic.gamemode;

import org.example.logic.GameSession;
public class HumanVsHumanMode extends GameSession {

    @Override
    protected String getWelcomeMessage() {
        return "Welcome to the Single game!\n";
    }

}
