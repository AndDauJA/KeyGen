package lt.daujotas;

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


}



