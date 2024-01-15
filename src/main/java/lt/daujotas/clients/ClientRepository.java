package lt.daujotas.clients;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientAccountPojo, UUID> {
    Optional<ClientAccountPojo> findByUuid (UUID id);

    void deleteClientByUuid (UUID id);
}
