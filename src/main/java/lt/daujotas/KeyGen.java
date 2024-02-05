package lt.daujotas;

import java.util.List;

public class KeyGen {


    public static String generateNoKey(int noOfRandChars) {

        GenerateChars generateChars = new GenerateChars();
        GenerateSpecialKey generateSpecialKey = new GenerateSpecialKey();

        String randomChars = generateChars.getRandomKeyChar(noOfRandChars);
//        String randomSpecChar = generateSpecialKey.getSpecKey(noOfRandChars);
//        String result = randomChars + randomSpecChar;
        String result = randomChars;

        System.out.println(result);
        return result;
    }
    public static String generatespecKey(int noOfRandChars) {

        GenerateChars generateChars = new GenerateChars();
        GenerateSpecialKey generateSpecialKey = new GenerateSpecialKey();

        String randomSpecKey = generateSpecialKey.getSpecKey(noOfRandChars);
//        String randomSpecChar = generateSpecialKey.getSpecKey(noOfRandChars);
//        String result = randomChars + randomSpecChar;
        String result2 = randomSpecKey;

        System.out.println(result2);
        return result2;
    }
    public static String generateLoremIps(int noOfRandWords) {
        LoremWordKeysGen generateLorem = new LoremWordKeysGen();
        List<String> loremWords = generateLorem.keyWordGen(noOfRandWords);

        // Čia jūs galite sujungti žodžius arba taikyti kitą loginę operaciją
        String result3 = String.join("-", loremWords);

//        System.out.println(result);
        return result3;
    }
}



