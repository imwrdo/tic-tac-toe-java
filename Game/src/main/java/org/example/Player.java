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
