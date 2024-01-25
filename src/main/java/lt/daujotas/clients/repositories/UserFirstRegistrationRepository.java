package lt.daujotas.clients.repositories;

import lt.daujotas.Users.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface UserFirstRegistrationRepository extends JpaRepository<ClientDto, String> {

    Optional<ClientDto> findClientDtoByUserName (String username);


}
