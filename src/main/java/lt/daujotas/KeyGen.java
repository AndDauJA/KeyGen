package lt.daujotas;

import java.util.List;

public class KeyGen {
    public static String generateNoKey(int noOfRandChars) {

        GenerateChars generateChars = new GenerateChars();
        String randomChars = generateChars.getRandomKeyChar(noOfRandChars);
        String result = randomChars;
        return result;
    }

    public static String generatespecKey(int noOfRandChars) {

        GenerateSpecialKey generateSpecialKey = new GenerateSpecialKey();
        String randomSpecKey = generateSpecialKey.getSpecKey(noOfRandChars);
        String result2 = randomSpecKey;
        return result2;
    }

    public static String generateLoremIps(int noOfRandWords) {

        LoremWordKeysGen generateLorem = new LoremWordKeysGen();
        List<String> loremWords = generateLorem.keyWordGen(noOfRandWords);
        String result3 = String.join("-", loremWords);
        return result3;
    }
}



