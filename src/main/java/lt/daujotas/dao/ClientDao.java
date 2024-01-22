package lt.daujotas.dao;

import lt.daujotas.clients.ClientAccountInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDao {
    void save(ClientAccountInfo clientAccountInfo);


    void update(ClientAccountInfo clientAccountInfo);

    List<ClientAccountInfo> getAll();

    Optional<ClientAccountInfo> getClientByUUID(UUID id);
    Optional<ClientAccountInfo> getClientByFirstName(String firstName);


    void deleteClientByUUID(UUID id);

    Page<ClientAccountInfo> getPage(Pageable pageable);

    Optional<ClientAccountInfo> getClientByUsername(String username);

}
