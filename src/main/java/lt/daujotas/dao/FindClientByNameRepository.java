package lt.daujotas.dao;

import lt.daujotas.clientPojo.ClientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FindClientByNameRepository extends JpaRepository<ClientData, String> {

    Optional<ClientData> findByFirstName(String firstName);
//    Optional<ClientData>findByUserName(String userName);
}
