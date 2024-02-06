package lt.daujotas.Users.repository;

import lt.daujotas.clients.ClientLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<ClientLoginInfo, String> {


    Optional<ClientLoginInfo> findByUsername (String username);

}
