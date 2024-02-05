package lt.daujotas;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class LoremWordKeysGen {



public List<String> keyWordGen(int fakeWordNumber) {
    Faker faker = new Faker();
    int lenghOFWordMin = 4;
    List<String> generatedWords = new ArrayList<>();

    for (int i = 0; i < fakeWordNumber; i++) {
        String loremips;
        do {
            loremips = faker.lorem().word();
        } while (countLetters(loremips) < lenghOFWordMin);

        generatedWords.add(loremips);
    }

    return generatedWords;
}

    private int countLetters(String word) {
        int letterCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount++;
            }
        }
        return letterCount;
    }

}

