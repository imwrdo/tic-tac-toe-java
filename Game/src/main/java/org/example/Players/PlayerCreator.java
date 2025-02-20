package org.example.Players;

import java.util.Scanner;

public class PlayerCreator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] VALID_CHARACTERS = {"X", "O"};

    // Player creator (used only for 1 player)
    public Player createPlayer(int id) {
        System.out.println("First player,please select your character (X or O):");
        String choice = scanner.nextLine();
        Player player = playerChoice(choice);
        if(player != null){
            return player;
        }
        System.out.println("Invalid choice, please select (X or O):");
        return null;
    }
    // Player character (X or O) validation
    public Player playerChoice(String choice){
        for(String character : VALID_CHARACTERS){
            if(choice.equals(character)){
                return new Player(1,choice);
            }
        }
        System.out.println("Invalid choice!");
        return null;
    }
}
