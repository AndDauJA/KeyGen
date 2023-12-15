package lt.daujotas;

import com.github.javafaker.Faker;

public class WordKeysGen {



//     String name = faker.name().fullName(); // Miss Samanta Schmidt
//    String firstName = faker.name().firstName(); // Emory
//    String lastName = faker.name().lastName(); // Barton
//    String streetAddress = faker.address().streetAddress();

    public void keyWordGen(){
        Faker faker = new Faker();
        int fakeWordNumber=5;

        for (int i=0; i<fakeWordNumber; i++){
            String loremips= faker.lorem().word();
            System.out.print(loremips+"-");
        }

    }
}
