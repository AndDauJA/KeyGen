package lt.daujotas.dao;

import lt.daujotas.Users.clientData.ClientData;
import lt.daujotas.dto.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDao {
    void save(ClientData clientData);
//    void saveClientDto(ClientData clientData);
    Optional<ClientData> getClientByFirstName(String firstName);


    void update(ClientData clientData);

    List<ClientData> getAll();

    Optional<ClientData> getClientByUUID(UUID id);

//    Optional<ClientAccountInfo> getClientByFirstName(String firstName);


    void deleteClientByUUID(UUID id);

    void deleteByClientUserName(String userName);

//    Page<ClientAccountInfo> getPage(Pageable pageable);
    Page<ClientData> getPage(Pageable pageable);

    Optional<ClientData> getClientByUsername(String username);


}
