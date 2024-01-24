package lt.daujotas.clients.repositories;


import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.clients.ClientLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface ClientLoginRepository extends JpaRepository<ClientLoginInfo, Long> {

    Optional<ClientAccountInfo> findByUsername(String username);

    ClientLoginInfo findByUsernameAndPassword(String username, String password);
}
