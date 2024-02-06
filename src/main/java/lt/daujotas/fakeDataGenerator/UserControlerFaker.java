package lt.daujotas.fakeDataGenerator;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class UserControlerFaker implements ApplicationRunner {
    UserDataFaker userDataFaker;

    public UserControlerFaker(UserDataFaker userDataFaker) {
        this.userDataFaker = userDataFaker;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
       userDataFaker.initRegister();
    }
}
