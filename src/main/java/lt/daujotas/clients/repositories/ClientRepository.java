package lt.daujotas.clients.repositories;

import lt.daujotas.clients.ClientAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientAccountInfo, UUID> {
    Optional<ClientAccountInfo> findByUuid (UUID id);
//    Optional<ClientAccountInfo> getClientByUsername (String userName);



    void deleteClientByUuid (UUID id);
}
