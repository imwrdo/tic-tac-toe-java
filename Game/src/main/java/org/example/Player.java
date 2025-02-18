package org.example;

public class Player {
    int id;
    String character;
    public Player(int id, String character) {
        this.id = id;
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}
