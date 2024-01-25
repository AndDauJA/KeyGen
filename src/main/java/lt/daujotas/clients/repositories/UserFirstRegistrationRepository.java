package lt.daujotas.clients.repositories;

import lt.daujotas.Users.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserFirstRegistrationRepository extends JpaRepository<ClientDto, String> {

    Optional<ClientDto> findClientDtoByFirstName (String name);


}
