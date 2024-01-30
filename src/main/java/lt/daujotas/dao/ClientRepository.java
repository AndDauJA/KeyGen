package lt.daujotas.dao;


import lt.daujotas.Users.clientData.ClientData;
import lt.daujotas.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientData, UUID> {
    Optional<ClientData> findByAccountUuid(UUID id);

//    @Query("SELECT ca FROM ClientAccountInfo ca JOIN ca.loginInfo la WHERE la.username = :username")
//    ClientData findByUsernName(@Param("username") String username);

    void deleteClientByAccountUuid (UUID accountUuind);
}
