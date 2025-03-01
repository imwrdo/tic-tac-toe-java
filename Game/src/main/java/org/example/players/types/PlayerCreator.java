package org.example.players.types;

import org.example.enums.Character;
import org.example.players.creator.Player;

import java.util.Scanner;

/**
 * Handles the creation of a Player by prompting for input and validating the chosen character.
 */
public class PlayerCreator {
    // Scanner for reading user input
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Creates a new Player by prompting the user to select a character ('X' or 'O').
     * @param id The ID assigned to the new player.
     * @return A new Player object with the specified ID and chosen character.
     * @throws IllegalArgumentException if the input is not 'X' or 'O'.
     */
    public Player createPlayer(int id) {
        System.out.println("Player %d,please select your character (X or O):"
                .formatted(id));
        String choice = SCANNER.nextLine();
        try {
            // Converts the user input into a valid Character enum
            Character character = Character.getCharacterFromString(choice);
            return new Player(id, character);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid choice, please select (X or O):");
        }
    }
}
