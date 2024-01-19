//package lt.daujotas.fakeDataGenerator;
//
//import com.github.javafaker.Faker;
//import lombok.AllArgsConstructor;
//import lt.daujotas.clients.ClientAccountPojo;
//import lt.daujotas.service.ClientAccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import java.sql.Date;
//import java.util.UUID;
//
//@Service
//
//public class DataFaker {
//    private static final int MAX_COUNT = 100;
//
//    private final ClientAccountService clientAccountService;
//
//
//    public DataFaker(ClientAccountService clientAccountService) {
//        this.clientAccountService = clientAccountService;
//        ;
//    }
//
//    @Transactional
//    public void initClient() {
//        Faker faker = new Faker();
//
//        for (int i = 0; i < MAX_COUNT; i++) {
//
//            String firstName = faker.name().firstName(); // Unikalus vardas
//            String lastName = faker.name().lastName(); // Unikali pavardė
//            Long phoneNu = faker.number().randomNumber();
//            java.util.Date utilBirthDate = faker.date().birthday();
//            Date birthDate = new Date(utilBirthDate.getTime());
//            String postAddress = faker.address().fullAddress();
//            String email = faker.name().username();
//            clientAccountService.saveClient(ClientAccountPojo.builder()
//                    .firstName(firstName)
//                    .lastName(lastName)
//                    .middleName(firstName)
//                    .phoneNumber(String.valueOf(phoneNu))
//                    .emailAddress(email)
//                    .uuid(UUID.randomUUID())
//                    .dateofbirth(birthDate)
//                    .postAddres(postAddress)
//                    .build());
//        }
//    }
////Papildziau duomenimins
//
//}
