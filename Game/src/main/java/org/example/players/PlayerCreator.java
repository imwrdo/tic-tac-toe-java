package org.example.players;

import org.example.enums.Character;
import java.util.Scanner;

public class PlayerCreator {
    private static final Scanner SCANNER = new Scanner(System.in);

    public Player createPlayer(int id) {
        System.out.println("Player %d,please select your character (X or O):"
                .formatted(id));
        String choice = SCANNER.nextLine();
        try {
            Character character = Character.getCharacterFromString(choice);
            return new Player(id, character);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid choice, please select (X or O):");
        }
    }
}
