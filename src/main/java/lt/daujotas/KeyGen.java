package lt.daujotas;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class KeyGen {


    public static String generateNoKey() {


//        Random random = new Random();
        GenerateChars generateChars = new GenerateChars();
        GenerateSpecialKey generateSpecialKey = new GenerateSpecialKey();
        SpecKeyAdditional specKeyAdditional = new SpecKeyAdditional();
        ExtraSpecialKey extraSpecialKey = new ExtraSpecialKey();


        String randomChars = generateChars.getRandomKeyChar();
        String randomSpecChar = generateSpecialKey.getSpecKey();
        String randomSpecCharAdditioal = specKeyAdditional.getSpecKeyAdditional();
        String randomExtraSpecKey = extraSpecialKey.getExtraSpecKey();
//        String result =  randomChars+randomSpecCharAdditioal + randmSk + randomSpecChar + randomExtraSpecKey;
        String result= randomChars+randomSpecChar;
        System.out.println(result);
        return result;
    }

//    private static List<Integer> extractDigits(int number) {
//        List<Integer> digits = new ArrayList<>();
//        while (number > 0) {
//            digits.add(0, number % 10);
//            number /= 10;
//        }
//        return digits;
//    }
//
//    private static int buildRandmSk(List<Integer> digits) {
//        int randmSk = 0;
//        for (Integer digit : digits) {
//            randmSk = randmSk * 10 + digit;
//        }
//        return randmSk;
//    }
}



