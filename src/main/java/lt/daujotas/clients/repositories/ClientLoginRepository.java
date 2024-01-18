package lt.daujotas.clients.repositories;


import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.clients.ClientLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ClientLoginRepository extends JpaRepository<ClientLoginInfo, String> {

    Optional<ClientAccountInfo> findByUsername(String username);

}
