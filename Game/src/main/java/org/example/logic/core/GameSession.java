package org.example.logic.core;

import org.example.enums.Character;
import org.example.players.creator.Player;
import org.example.players.types.PlayerCreator;

public abstract class GameSession {

    // Object of first player in the game
    protected Player firstPlayer;

    // Object of second player in the game
    protected Player secondPlayer;

    // Utility to create players based on user input
    protected final PlayerCreator playerCreator = new PlayerCreator();

    // Logic handler for the game process
    protected GameProcessLogicHandler gameProcessLogicHandler = new GameProcessLogicHandler();

    /**
     * Starts the game session by displaying a welcome message,
     * setting up players, and starting the game loop.
     */
    public final void startGame() {
        System.out.println(getWelcomeMessage());
        setupPlayers();
        gameProcessLogicHandler.playGame(firstPlayer, secondPlayer, true);
        System.out.println("\nGame Over!");
    }

    /**
     * Sets up the first and second players.
     * Ensures the first player is valid and assigns the opposite character to the second player.
     */
    protected void setupPlayers(){
        do {
            firstPlayer = playerCreator.createPlayer(1);
        } while (firstPlayer == null);

        Character secondPlayerChar = firstPlayer.getCharacterEnum() == Character.X
                ? Character.O
                : Character.X;
        secondPlayer = new Player(2, secondPlayerChar);
    }

    /**
     * Provides a welcome message specific to the game session.
     * This method must be implemented by subclasses.
     * @return The welcome message as a string.
     */
    protected abstract String getWelcomeMessage();



}

