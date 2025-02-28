package org.example.logic;

import org.example.enums.Character;
import org.example.players.Player;
import org.example.players.PlayerCreator;

public abstract class GameSession {
    protected Player firstPlayer;
    protected Player secondPlayer;
    protected final PlayerCreator playerCreator = new PlayerCreator();
    protected GameProcessLogic gameProcessLogic = new GameProcessLogic();

    public final void startGame() {
        System.out.println(getWelcomeMessage());
        setupPlayers();
        gameProcessLogic.playGame(firstPlayer, secondPlayer, true);
        System.out.println("\nGame Over!");
    }
    protected void setupPlayers(){
        do {
            firstPlayer = playerCreator.createPlayer(1);
        } while (firstPlayer == null);

        Character secondPlayerChar = firstPlayer.getCharacterEnum() == Character.X
                ? Character.O
                : Character.X;
        secondPlayer = new Player(2, secondPlayerChar);
    }
    protected abstract String getWelcomeMessage();



}

