package lt.daujotas.dao;

import lt.daujotas.clients.ClientAccountPojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDao {
    void save(ClientAccountPojo clientAccountPojo);

    void update(ClientAccountPojo clientAccountPojo);

    List<ClientAccountPojo> getAll();

    Optional<ClientAccountPojo> getClientByUUID(UUID id);
    void deleteClientByUUID(UUID id);

    Page<ClientAccountPojo> getPage(Pageable pageable);
}
