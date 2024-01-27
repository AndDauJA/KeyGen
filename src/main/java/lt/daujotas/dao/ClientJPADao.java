package lt.daujotas.dao;

import jakarta.persistence.EntityManager;
import lt.daujotas.Users.dto.ClientDto;
import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.clients.repositories.ClientRepository;
import lt.daujotas.clients.repositories.FindClientByNameRepository;
import lt.daujotas.clients.repositories.UserFirstRegistrationRepository;
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
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserFirstRegistrationRepository userFirstRegistrationRepository;


    @Override
    public void save(ClientDto clientDto) {
        clientDto.setAccountUuid(UUID.randomUUID());
        userFirstRegistrationRepository.save(clientDto);
    }

    @Override
    public void update(ClientDto clientDto) {
        Optional<ClientDto> savedOptionalUser = getClientByUsername(clientDto.getUserName());
        if (savedOptionalUser.isPresent()) {

            ClientDto savedByUserName = savedOptionalUser.get();
            savedByUserName.setFirstName(clientDto.getFirstName());
//             user.setPassword("newPassword");

        userFirstRegistrationRepository.save(savedByUserName);
    }
}

    @Override
    public List<ClientAccountInfo> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ClientAccountInfo> getClientByUUID(UUID id) {
        return repository.findByAccountUuid(id);
    }

    @Override
    public Optional<ClientDto> getClientByFirstName(String userName) {
        return userFirstRegistrationRepository.findClientDtoByUserName(userName);
    }

    @Override
    public void deleteClientByUUID(UUID id) {
        Optional<ClientAccountInfo> client = repository.findByAccountUuid(id);
        client.ifPresent(repository::delete);

    }

    @Override
    public void deleteByClientUserName(String userName) {
        Optional<ClientDto> clientDto = userFirstRegistrationRepository.findClientDtoByUserName(userName);
        clientDto.ifPresent(userFirstRegistrationRepository::delete);
    }

    //    @Override
//    public Page<ClientAccountInfo> getPage(Pageable pageable) {
//        return repository.findAll(pageable);
//    }
    @Override
    public Page<ClientDto> getPage(Pageable pageable) {
        return userFirstRegistrationRepository.findAll(pageable);
    }

    @Override
    public Optional<ClientDto> getClientByUsername(String username) {

        return userFirstRegistrationRepository.findClientDtoByUserName(username);
    }


}


