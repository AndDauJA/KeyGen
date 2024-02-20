package lt.daujotas.Users.dao;

import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserGeneralDao {
    void save (UserGeneralLoginCredentialsData userGeneralLoginCredentialsData);
    void update(UserGeneralLoginCredentialsData userGeneralLoginCredentialsData);
    List<UserGeneralLoginCredentialsData> getAll();
    Optional<UserGeneralLoginCredentialsData> getDataByUUID(UUID id);
    void deleteDataByUUID(UUID id);

    void deleteByClientUserName(String userName);

    //    Page<ClientAccountInfo> getPage(Pageable pageable);
    Page<UserGeneralLoginCredentialsData> getPage(Pageable pageable);
}
