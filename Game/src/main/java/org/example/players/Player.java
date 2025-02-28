package org.example.players;

import org.example.enums.Character;

public class Player {
    private final int id;
    private final Character character;

    public Player(int id, Character character) {
        this.id = id;
        this.character = character;
    }

    public String getCharacter() {
        return character.getCharacterValue();
    }

    public Character getCharacterEnum() {
        return character;
    }

    public int getId() {
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
