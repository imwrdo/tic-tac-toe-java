package org.example.enums;

import java.util.Arrays;

public enum Character {
    X("X"), O("O");

    private final String value;

    Character(String value) {
        this.value = value;
    }

    public String getCharacterValue() {
        return value;
    }

    public static Character getCharacterFromString(String value) {
        return Arrays.stream(values())
                .filter(c -> c.getCharacterValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid character: " + value));
    }

}
