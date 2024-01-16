package lt.daujotas.clients;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientLoginRepository extends JpaRepository<ClientLoginPojo, String> {

    Optional<ClientAccountPojo> findByUsername(String username);

}
