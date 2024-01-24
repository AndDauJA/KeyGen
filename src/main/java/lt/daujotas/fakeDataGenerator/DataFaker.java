//package lt.daujotas.fakeDataGenerator;
//
//import com.github.javafaker.Faker;
//
//import lt.daujotas.clients.ClientAccountInfo;
//import lt.daujotas.clients.ClientLoginInfo;
//import lt.daujotas.service.ClientAccountService;
//import lt.daujotas.service.ClientLoginService;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
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
//    private final ClientLoginService clientLoginService;
//
//
//    public DataFaker(ClientAccountService clientAccountService, ClientLoginService clientLoginService) {
//        this.clientAccountService = clientAccountService;
//        this.clientLoginService = clientLoginService;
//
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
//
//            java.util.Date utilBirthDate = faker.date().birthday();
//            Date birthDate = new Date(utilBirthDate.getTime());
//            String postAddress = faker.address().fullAddress();
//            String email = faker.name().username();
//            String username=faker.name().username();
//            clientAccountService.saveClient(ClientAccountInfo.builder()
//                    .firstName(firstName)
//                    .lastName(lastName)
//                    .middleName(firstName)
//                    .phoneNumber(String.valueOf(phoneNu))
//                    .emailAddress(email)
//                    .accountUuid(UUID.randomUUID())
//                    .dateofbirth(birthDate)
//                    .postAddres(postAddress)
//                    .build());
//            clientLoginService.saveLoginClient(ClientLoginInfo.builder()
//                    .username(username)
//                    .password(lastName)
//                    .build());
//        }
//    }
////Papildziau duomenimins
//
//}
