package lt.daujotas;

public class KeyGen {


    public static String generateNoKey() {
        GenerateChars generateChars = new GenerateChars();
        GenerateSpecialKey generateSpecialKey = new GenerateSpecialKey();

        String randomChars = generateChars.getRandomKeyChar();
        String randomSpecChar = generateSpecialKey.getSpecKey();
        String result = randomChars + randomSpecChar;


        System.out.println(result);
        return result;
    }


}



