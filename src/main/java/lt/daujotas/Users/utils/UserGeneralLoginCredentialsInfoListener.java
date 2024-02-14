package lt.daujotas.Users.utils;

import jakarta.persistence.PrePersist;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class UserGeneralLoginCredentialsInfoListener {
    @PrePersist
    public void prePersist(UserGeneralLoginCredentialsData user) {
        user.setDateAdded(new Date());
    }
}
