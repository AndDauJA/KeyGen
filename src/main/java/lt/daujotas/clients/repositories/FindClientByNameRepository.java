package lt.daujotas.clients.repositories;

import lt.daujotas.clients.ClientAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FindClientByNameRepository extends JpaRepository<ClientAccountInfo, String> {

    Optional<ClientAccountInfo> findByFirstName(String firstName);
}
