package org.example.enums;

import java.util.Arrays;

/**
 * Enum representing the characters used in the game ('X' and 'O').
 * Provides utility methods for retrieving character values and parsing input strings.
 */
public enum Character {
    // Enum constants for 'X' and 'O' characters
    X("X"), O("O");

    // String representation of the character
    private final String value;

    /**
     * Constructor to initialize the character with its string value.
     * @param value The string value of the character ('X' or 'O').
     */
    Character(String value) {
        this.value = value;
    }

    /**
     * Retrieves the string representation of the character.
     * @return The character value as a string ('X' or 'O').
     */
    public String getCharacterValue() {
        return value;
    }

    /**
     * Converts a string input to a Character enum if valid.
     * @param value The input string ('X' or 'O').
     * @return The corresponding Character enum.
     * @throws IllegalArgumentException if the input is not a valid character.
     */
    public static Character getCharacterFromString(String value) {
        return Arrays.stream(values())
                .filter(c -> c.getCharacterValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid character: " + value));
    }

}
