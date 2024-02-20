//package lt.daujotas;
//
//import java.util.Random;
//
//public class ExtraSpecialKey {
//    static Random random = new Random();
//    static int noOfRandChars = 1;
//
//    public String getExtraSpecKey() {
//
//        return getCharToString(noOfRandChars);
//
//    }
//
//    private static String getCharToString(int minLength) {
//        String possibleChars = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        int minLetters = noOfRandChars;
//        int minNumbers = noOfRandChars;
//        int numLetters = Math.max(random.nextInt(minLength - minNumbers + 1), minLetters); // Ensure at least minLetters
//        int numNumbers = Math.max(minLength - numLetters, minNumbers); // Ensure at least minNumbers
//
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < numLetters; i++) {
//            int index = random.nextInt(possibleChars.length());
//            result.append(possibleChars.charAt(index));
//        }
//
//        for (int i = 0; i < numNumbers; i++) {
//            int index = random.nextInt(10); // Index for numbers (0-9)
//            result.append((char) ('0' + index)); // Convert the index to the corresponding digit
//        }
//
//        // Append special characters
//        for (int i = 0; i < minLength - numLetters - numNumbers; i++) {
//            int index = random.nextInt(possibleChars.length());
//            result.append(possibleChars.charAt(index));
//        }
//
//
//        // Shuffle the characters to randomize their order
//        return shuffleString(result.toString());
//    }
//
//    private static String shuffleString(String input) {
//        char[] characters = input.toCharArray();
//        for (int i = characters.length - 1; i > 0; i--) {
//            int index = random.nextInt(i + 1);
//            char temp = characters[index];
//            characters[index] = characters[i];
//            characters[i] = temp;
//        }
//        return new String(characters);
//    }
//
//}
