package lt.daujotas.dao;

import lt.daujotas.Users.dto.ClientDto;
import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.clients.ClientLoginInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDao {
    void save(ClientAccountInfo clientAccountInfo);
    void saveClientDto(ClientDto clientDto);



    void update(ClientAccountInfo clientAccountInfo);

    List<ClientAccountInfo> getAll();

    Optional<ClientAccountInfo> getClientByUUID(UUID id);

    Optional<ClientAccountInfo> getClientByFirstName(String firstName);


    void deleteClientByUUID(UUID id);

    void deleteByClientUserName(String userName);

//    Page<ClientAccountInfo> getPage(Pageable pageable);
    Page<ClientDto> getPage(Pageable pageable);

    Optional<ClientAccountInfo> getClientByUsername(String username);

    Optional<ClientLoginInfo> findByUsername(String username);
}
