package org.example.players;

import org.example.enums.Character;
import java.util.Scanner;

public class PlayerCreator {
    private static final Scanner SCANNER = new Scanner(System.in);

    public Player createPlayer() {
        System.out.println("First player,please select your character (X or O):");
        String choice = SCANNER.nextLine();
        try {
            Character character = Character.fromString(choice);
            return new Player(1, character);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid choice, please select (X or O):");
        }
    }
}
