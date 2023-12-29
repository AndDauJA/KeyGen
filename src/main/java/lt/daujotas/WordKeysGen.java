package lt.daujotas;

import com.github.javafaker.Faker;

public class WordKeysGen {


//     String name = faker.name().fullName(); // Miss Samanta Schmidt
//    String firstName = faker.name().firstName(); // Emory
//    String lastName = faker.name().lastName(); // Barton
//    String streetAddress = faker.address().streetAddress();

    public void keyWordGen(int fakeWordNumber) {
        Faker faker = new Faker();
        int lenghOFWordMin = 4;
        for (int i = 0; i < fakeWordNumber; i++) {
            String loremips;
            do {
                loremips = faker.lorem().word();
            } while (countLetters(loremips) < lenghOFWordMin);

            System.out.print(loremips + " ");
        }
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

