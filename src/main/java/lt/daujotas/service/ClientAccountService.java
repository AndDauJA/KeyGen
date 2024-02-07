package lt.daujotas.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lt.daujotas.Users.clientData.ClientData;
import lt.daujotas.clients.mappers.ClientMapper;
import lt.daujotas.dao.ClientDao;
import lt.daujotas.dto.ClientDto;
import lt.daujotas.exception.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientAccountService {

    private final ClientDao clientDao;
    private final ClientMapper clientMapper;


//    public void saveClient(ClientData clientData) {
//
//        clientDao.save(clientData);
//    }

public void updateAllClientData(String userName, String firstName, String lastName, String middleName,
                         String postAddress, String phoneNumber, String emailAddress) {
    Optional<ClientData> optionalClientData = clientDao.getClientByUsername(userName);

    if (optionalClientData.isPresent()) {
        ClientData clientData = optionalClientData.get();
        ClientDto clientDto = clientMapper.toDto(clientData);

        clientDto.setFirstName(firstName);
        clientDto.setLastName(lastName);
        clientDto.setMiddleName(middleName);
        clientDto.setPostAddres(postAddress);
        clientDto.setPhoneNumber(phoneNumber);
        clientDto.setEmailAddress(emailAddress);
        clientMapper.fromDto(clientDto, clientData);
        clientDao.update(clientData);
    } else {

        throw new RuntimeException("Client not found with username: " + userName);
    }
}

    public Optional<ClientData> getClientByUserName(String userName)
    {
        return clientDao.getClientByUsername(userName);

    }

    public List<ClientData> getAllClients() {
        return clientDao.getAll();
    }

//    public ClientDto getClientByUUID(UUID clientUUID) {
//        return clientDao.getClientByUUID(clientUUID)
//                .map(clientData -> clientMapper.toDto(clientData))
//                .orElseThrow(()-> new ClientNotFoundException(clientUUID));
//    }
    public void deleteClientByUserName(String userName){
        clientDao.deleteByClientUserName(userName);
    }

    @Transactional
    public void deleteClientByUUID(UUID id) {
        clientDao.deleteClientByUUID(id);
    }

    public Page<ClientData> getAllClientsPages(Pageable pageable) {
        return clientDao.getPage(pageable);
    }


    }

