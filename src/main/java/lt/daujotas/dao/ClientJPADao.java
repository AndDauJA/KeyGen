package lt.daujotas.dao;

import jakarta.persistence.EntityManager;
import lt.daujotas.clientPojo.ClientData;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClientJPADao implements ClientDao {
    private final ClientRepository repository;
    FindClientByNameRepository findClientByNameRepository;
    private EntityManager entityManager;
    UserFirstRegistrationRepository userFirstRegistrationRepository;

    @Autowired
    public ClientJPADao(ClientRepository repository, FindClientByNameRepository findClientByNameRepository, EntityManager entityManager, UserFirstRegistrationRepository userFirstRegistrationRepository) {
        this.repository = repository;
        this.findClientByNameRepository = findClientByNameRepository;
        this.entityManager = entityManager;
        this.userFirstRegistrationRepository = userFirstRegistrationRepository;
    }

    @Override
    public void save(ClientData clientData) {
        clientData.setAccountUuid(UUID.randomUUID());
        userFirstRegistrationRepository.save(clientData);
    }

    @Override
    public void update(ClientData clientData) {
        Optional<ClientData> savedOptionalUser = getClientByUsername(clientData.getUserName());
        if (savedOptionalUser.isPresent()) {

            ClientData savedByUserName = savedOptionalUser.get();
            savedByUserName.setFirstName(clientData.getFirstName());
//             user.setPassword("newPassword");

            userFirstRegistrationRepository.save(savedByUserName);
        }
    }

    @Override
    public List<ClientData> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ClientData> getClientByUUID(UUID id) {
        return repository.findByAccountUuid(id);
    }

    @Override
    public Optional<ClientData> getClientByFirstName(String firsName) {
        return findClientByNameRepository.findByFirstName(firsName);
    }

    @Override
    public void deleteClientByUUID(UUID id) {
        Optional<ClientData> client = repository.findByAccountUuid(id);
        client.ifPresent(repository::delete);

    }

    @Override
    public void deleteByClientUserName(String userName) {
        Optional<ClientData> clientDto = userFirstRegistrationRepository.findClientDtoByUserName(userName);
        clientDto.ifPresent(userFirstRegistrationRepository::delete);
    }

    @Override
    public Page<ClientData> getPage(Pageable pageable) {
        return userFirstRegistrationRepository.findAll(pageable);
    }

    @Override
    public Optional<ClientData> getClientByUsername(String username) {

        return userFirstRegistrationRepository.findClientDtoByUserName(username);
    }


}


