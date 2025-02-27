package org.example.players;

public class Player {
    private final int id;
    private final String character;
    public Player(int id, String character) {
        this.id = id;
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", character='" + character + '\'' +
                '}';
    }
}
