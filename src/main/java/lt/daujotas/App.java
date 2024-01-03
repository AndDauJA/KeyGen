package lt.daujotas;

import lt.daujotas.config.HibernateConfig;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.security.SecureRandom;

/**
 * Hello world!
 */
public class App {
      public static void main(String[] args) throws IOException {
          HibernateConfig.init();

        //Lorem ipsum - pasirinkti kiek zodziu
        int fakeWordNumber = 5;
        new LoremWordKeysGen().keyWordGen(fakeWordNumber);

        //GenerateChars.noOfRandChars = 1; // 1- viena raide+1 skaicius, 2- 2raides ir 2 skaiciai
//        GenerateSpecialKey.noOfRandChars = 1;                 // 1 - => 1 specraide ir simboli +1 skaicius arba spec simboli, etc
//
//        KeyGen.generateNoKey(3);
//        new SplashScreen();
//        try {
//            new PasswordManager(0);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        GenKeySaveToFile.fileOutGoing(0);
//      PasswEntrophyCalc.centrohyCalculator();
//        System.out.println(generatePassword(8));
    }
}
