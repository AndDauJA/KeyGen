package lt.daujotas;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    private static final SecureRandom random = new SecureRandom();
    private static final String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String small_caps = "abcdefghijklmnopqrstuvwxyz";
    private static final String Numeric = "1234567890";
    private static final String special_char = "~!@#$%^&*(_+{}|:_[?]>=<";
    private static final String dic = caps + small_caps + Numeric + special_char;

    public static void main(String[] args) throws IOException {

//        WordKeysGen wordKeysGen = new WordKeysGen();
//        int fakeWordNumber = 5;
//        wordKeysGen.keyWordGen(fakeWordNumber);                  //Lorem ipsum - pasirinkti kiek zodziu
//
        //GenerateChars.noOfRandChars = 1; // 1- viena raide+1 skaicius, 2- 2raides ir 2 skaiciai
//        GenerateSpecialKey.noOfRandChars = 1;                 // 1 - => 1 specraide ir simboli +1 skaicius arba spec simboli, etc
//
//        KeyGen.generateNoKey(3);
        new SplashScreen();
        try {
            new PasswordManager(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        GenKeySaveToFile.fileOutGoing(0);
//
//      PasswEntrophyCalc.centrohyCalculator();


//        public static String generatePassword() {
//            StringBuilder password= new StringBuilder();
//            int len=1;
//            for (int i = 0; i <len ; i++) {
//                int index = random.nextInt(dic.length());
//                password.append(dic.charAt(index));
//            }
//            return password.toString();
//        }
//
    }

}
