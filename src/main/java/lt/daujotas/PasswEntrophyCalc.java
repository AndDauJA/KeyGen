package lt.daujotas;

public class PasswEntrophyCalc {


    public static void centrohyCalculator() {
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String possibleCharsadd = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        String possibleNumber = "0123456789";

        String password = "IncoRRect77@";

        // Calculate and print password entropy
        double entropy = calculateEntropy(password);
        System.out.println("Password Entropy: " + entropy + " bits");


    }

    private static double calculateEntropy(String password) {
        int passwordLength = password.length();
        int symbolSetSize =(containsLowerCase(password) + containsUpperCase(password) + containsNumbers(password)+containsNSpecSimbol(password));
//        int lowerCase = containsLowerCase(password);
//        int upperCase = containsUpperCase(password);
//        int numberCase = containsNumbers(password);
//        int specSimbolCase=containsNSpecSimbol(password);

        return passwordLength * (Math.log(symbolSetSize) / Math.log(2));
    }


    private static int containsLowerCase(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return 26;
            }
        }
        return 0;
    }

    private static int containsUpperCase(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return 26;
            }
        }
        return 0;
    }

    private static int containsNumbers(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return 10;
            }
        }
        return 0;


    }
    private static int containsNSpecSimbol(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return 33;
            }
        }
        return 0;


    }

}