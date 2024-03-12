package lt.daujotas.dao;


import lt.daujotas.clientPojo.ClientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientData, Long> {
    Optional<ClientData> findByAccountUuid(UUID id);

    Optional<ClientData> findByUserName(String username);

//    @Query("SELECT ca FROM ClientAccountInfo ca JOIN ca.loginInfo la WHERE la.username = :username")
//    ClientData findByUsernName(@Param("username") String username);

    void deleteClientByAccountUuid(UUID accountUuind);
//    Optional<ClientData> findByUsername(String username);
}
