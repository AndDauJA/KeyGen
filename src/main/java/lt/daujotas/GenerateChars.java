package lt.daujotas;

import java.util.Random;

public class GenerateChars {
    static Random random = new Random();
    static int noOfRandChars=1;
    public String getRandomKeyChar(int noOfRandChars){

        return getCharToString(noOfRandChars);
    }
    private static String getCharToString(int minLength) {
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~abcdefghijklmnopqrstuvwxyz";
        int minLetters = noOfRandChars;
        int minNumbers = noOfRandChars;
        int numLetters = Math.max(random.nextInt(minLength - minNumbers+1), minLetters);
        int numNumbers = Math.max(minLength - numLetters, minNumbers);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numLetters; i++) {
            int index = random.nextInt(possibleChars.length());
            result.append(possibleChars.charAt(index));
        }

        for (int i = 0; i < numNumbers; i++) {
            int index = random.nextInt(10); // SKAICIAI (0-9)
            result.append((char) ('0' + index)); // skaiciai nuo index 26
        }


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
