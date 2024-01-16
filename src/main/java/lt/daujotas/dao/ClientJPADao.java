package lt.daujotas.dao;

import lt.daujotas.clients.ClientAccountPojo;
import lt.daujotas.clients.ClientLoginPojo;
import lt.daujotas.clients.ClientLoginRepository;
import lt.daujotas.clients.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClientJPADao implements ClientDao {
    ClientRepository repository;


    @Autowired
    public ClientJPADao(ClientRepository clientRepository) {
        this.repository = clientRepository;
    }


    @Override
    public void save(ClientAccountPojo clientAccountPojo) {
//        clientAccountPojo.setUuid(UUID.randomUUID());
        repository.save(clientAccountPojo);
    }



    @Override
    public void update(ClientAccountPojo clientAccountPojo) {
        repository.save(clientAccountPojo);
    }

    @Override
    public List<ClientAccountPojo> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ClientAccountPojo> getClientByUUID(UUID id) {
        return repository.findByUuid(id);
    }

    @Override
    public void deleteClientByUUID(UUID id) {
        Optional<ClientAccountPojo> client = repository.findById(id);
        client.ifPresent(repository::delete);

    }

    @Override
    public Page<ClientAccountPojo> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
