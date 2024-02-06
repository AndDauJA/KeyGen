package lt.daujotas.fakeDataGenerator;


import lt.daujotas.Users.clientData.ClientData;
import lt.daujotas.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.UUID;

@Service
public class UserDataFaker {
    private final UserService userService;

    public UserDataFaker(UserService userService) {
        this.userService = userService;

    }

    @Transactional
    public void initRegister() {
        userService.saveNewClient(ClientData.builder()
                .userName("admin")
                .accountUuid(UUID.randomUUID())
                .firstName("Andrius")
                .lastName("Daujotas")
                .middleName("nera")
                .postAddres("Ligonines g.5-8")
                .phoneNumber("+37065199998")
                .dateofbirth(Date.valueOf("1979-01-31"))
                .gender("male")
                .password(new BCryptPasswordEncoder().encode("admin"))
                .repeatPassrowd("admin")
                .emailAddress("daujotasand@gmail.com")
                .build());

    }
}
