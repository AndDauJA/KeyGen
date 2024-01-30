package lt.daujotas.dao;

import lt.daujotas.Users.clientData.ClientData;
import lt.daujotas.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FindClientByNameRepository extends JpaRepository<ClientData, String> {

    Optional<ClientData> findByFirstName(String firstName);
}
