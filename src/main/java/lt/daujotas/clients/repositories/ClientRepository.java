package lt.daujotas.clients.repositories;

import lt.daujotas.Users.dto.ClientDto;
import lt.daujotas.clients.ClientAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientAccountInfo, UUID> {
    Optional<ClientAccountInfo> findByAccountUuid(UUID id);

//    @Query("SELECT ca FROM ClientAccountInfo ca JOIN ca.loginInfo la WHERE la.username = :username")
//    ClientDto findByUsernName(@Param("username") String username);

    void deleteClientByAccountUuid (UUID accountUuind);
}
