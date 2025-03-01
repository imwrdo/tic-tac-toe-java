package org.example.players.creator;

import org.example.enums.Character;

/**
 * Represents a player in the game, holding an ID and a character ('X' or 'O').
 */
public class Player {

    // Unique identifier for the player
    private final int id;

    // Character associated with the player ('X' or 'O')
    private final Character character;

    /**
     * Constructs a Player with a specific ID and character.
     * @param id        The unique ID of the player.
     * @param character The character assigned to the player.
     */
    public Player(int id, Character character) {
        this.id = id;
        this.character = character;
    }

    /**
     * Retrieves the character associated with the player as a string.
     * @return The player's character value ('X' or 'O').
     */
    public String getCharacter() {
        return character.getCharacterValue();
    }

    /**
     * Retrieves the character associated with the player as an enum.
     * @return The player's character enum.
     */
    public Character getCharacterEnum() {
        return character;
    }

    /**
     * Retrieves the player's unique ID.
     * @return The ID of the player.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns a string representation of the player, including ID and character.
     * @return A string describing the player.
     */
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", character='" + character + '\'' +
                '}';
    }


}
