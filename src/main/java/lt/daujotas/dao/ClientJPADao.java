package lt.daujotas.dao;

import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.clients.repositories.ClientRepository;
import lt.daujotas.clients.repositories.FindClientByNameRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClientJPADao implements ClientDao {
    @Autowired
    ClientRepository repository;
    @Autowired
    FindClientByNameRepository findClientByNameRepository;



//    public ClientJPADao(ClientRepository clientRepository) {
//        this.repository = clientRepository;
//
//    }


    @Override
    public void save(ClientAccountInfo clientAccountInfo) {
        clientAccountInfo.setUuid(UUID.randomUUID());
        repository.save(clientAccountInfo);
    }


    @Override
    public void update(ClientAccountInfo clientAccountInfo) {
        repository.save(clientAccountInfo);
    }

    @Override
    public List<ClientAccountInfo> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ClientAccountInfo> getClientByUUID(UUID id) {
        return repository.findByUuid(id);
    }
    @Override
    public Optional<ClientAccountInfo> getClientByFirstName(String firstName) {
        return findClientByNameRepository.findByFirstName(firstName);
    }
    @Override
    public void deleteClientByUUID(UUID id) {
        Optional<ClientAccountInfo> client = repository.findById(id);
        client.ifPresent(repository::delete);

    }

    @Override
    public Page<ClientAccountInfo> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<ClientAccountInfo> getClientByUsername(String username) {
        return Optional.empty();
    }



}

