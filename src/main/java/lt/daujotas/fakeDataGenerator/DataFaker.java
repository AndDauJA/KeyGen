//package lt.daujotas.fakeDataGenerator;
//
//import com.github.javafaker.Faker;
//
//import lt.daujotas.Users.dto.ClientData;
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
//
//
//    public DataFaker(ClientAccountService clientAccountService) {
//        this.clientAccountService = clientAccountService;
//
//
//    }
//
//    @Transactional
//    public void initClient() {
//        Faker faker = new Faker();
//
//        for (int i = 0; i < MAX_COUNT; i++) {
//
//            String firstName = faker.name().firstName();
//            String lastName = faker.name().lastName();
//            String phoneNu = "+370"+faker.number().numberBetween(10000000, 99999999);
//
//            java.util.Date utilBirthDate = faker.date().birthday();
//            Date birthDate = new Date(utilBirthDate.getTime());
//            String postAddress = faker.address().fullAddress();
//            String email = faker.name().username()+"@"+"gmail.com";
//            String username = faker.name().username();
//            String password =faker.animal().name();
//            clientAccountService.saveClientDto(ClientData.builder()
//                    .userName(username)
//                    .firstName(firstName)
//                    .lastName(lastName)
//                    .middleName(firstName)
//                    .phoneNumber(phoneNu)
//                    .emailAddress(email)
//                    .accountUuid(UUID.randomUUID())
//                    .dateofbirth(birthDate)
//                    .postAddres(postAddress)
//                    .password(password)
//                    .repeatPassrowd(password)
//                    .build());
//
//        }
//    }
////Papildziau duomenimins
//
//}
