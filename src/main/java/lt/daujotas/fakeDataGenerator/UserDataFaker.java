//package lt.daujotas.fakeDataGenerator;
//
//
//import lt.daujotas.clients.ClientLoginInfo;
//import lt.daujotas.service.UserService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//@Service
//public class UserDataFaker {
//    private final UserService userService;
//
//    public UserDataFaker(UserService userService) {
//        this.userService = userService;
//
//    }
//    @Transactional
//    public void initRegister(){
//        userService.register(ClientLoginInfo.builder()
//                        .username("admin")
//                        .password(new BCryptPasswordEncoder().encode("admin"))
//                .build());
//
//    }
//}
