package lt.daujotas;

import java.util.Random;

public class GenerateSpecialKey {
    static Random random = new Random();
    static int noOfRandSpecChars = 1;

    public String getSpecKey(int noOfRandSpecChars) {
        return getCharToString(noOfRandSpecChars);
    }

    private static String getCharToString(int minLength) {
        String possibleChars = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        int minLetters = noOfRandSpecChars;
        int minNumbers = noOfRandSpecChars;
        int numLetters = Math.max(random.nextInt(minLength - minNumbers + 1), minLetters); // Ensure at least minLetters
        int numNumbers = Math.max(minLength - numLetters, minNumbers); // Ensure at least minNumbers

        StringBuilder result = new StringBuilder();

        // Append lowercase and uppercase letters
        for (int i = 0; i < numLetters; i++) {
            int index = random.nextInt(possibleChars.length());
            result.append(possibleChars.charAt(index));
        }

        // Append numbers
        for (int i = 0; i < numNumbers; i++) {
            int index = random.nextInt(9); // Index for numbers (0-9)
            result.append((char) ('0' + index)); // Convert the index to the corresponding digit
        }

        // Append special characters
        for (int i = 0; i < minLength - numLetters - numNumbers; i++) {
            int index = random.nextInt(possibleChars.length());
            result.append(possibleChars.charAt(index));
        }

        // Shuffle the characters to randomize their order
        return shuffleString(result.toString());
    }

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = characters.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = characters[index];
            characters[index] = characters[i];
            characters[i] = temp;
        }
        return new String(characters);
    }
}
