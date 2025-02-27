package org.example.players;

import java.util.Scanner;

public class PlayerCreator {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[] VALID_CHARACTERS = {"X", "O"};

    // Player creator (used only for 1 player)
    public Player createPlayer() {
        System.out.println("First player,please select your character (X or O):");
        String choice = SCANNER.nextLine();
        Player player = playerChoice(choice);

        if(player != null){
            return player;
        }

        throw new IllegalArgumentException("Invalid choice, please select (X or O):");
    }

    // Player character (X or O) validation
    public Player playerChoice(String choice){
        for(String character : VALID_CHARACTERS){
            if(choice.equals(character)){
                return new Player(1,choice);
            }
        }
        throw new IllegalArgumentException("Invalid choice, please select (X or O):");
    }
}
