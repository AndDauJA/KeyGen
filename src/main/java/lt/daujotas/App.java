package lt.daujotas;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        WordKeysGen wordKeysGen=new WordKeysGen();
//        wordKeysGen.keyWordGen();
       int numberOfRandomVar=GenerateChars.noOfRandChars=1; // 1- viena raide+1 skaicius, 2- 2raides ir 2 skaiciai
        GenerateSpecialKey.noOfRandChars=2;                 // 1 - => 1 specraide ir simboli +1 skaicius arba spec simboli, etc
//        SpecKeyAdditional.noOfRandChars=5;
       KeyGen.generateNoKey();
//       GenKeySaveToFile.fileOutGoing(0);
//PasswEntrophyCalc.centrohyCalculator();
    }
}
