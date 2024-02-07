package lt.daujotas.dao;

import lt.daujotas.Users.clientData.ClientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface UserFirstRegistrationRepository extends JpaRepository<ClientData, String> {

    Optional<ClientData> findClientDtoByUserName (String username);
    @Query(value = "SELECT u FROM ClientData u JOIN FETCH u.authorities WHERE u.userName= :username")
    Optional<ClientData> findClientDataByUsernameWithinAndAuthorities (String username);

}
