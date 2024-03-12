package lt.daujotas.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lt.daujotas.clientPojo.ClientData;
import lt.daujotas.mapper.ClientMapper;
import lt.daujotas.dao.ClientDao;
import lt.daujotas.dto.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
                                    String postAddress, String phoneNumber, String emailAddress, Date birthDate, String gender) {
        Optional<ClientData> optionalClientData = clientDao.getClientByUsername(userName);

        if (optionalClientData.isPresent()) {
            ClientData clientData = optionalClientData.get();
            clientData.setFirstName(firstName);
            clientData.setLastName(lastName);
            clientData.setMiddleName(middleName);
            clientData.setPostAddres(postAddress);
            clientData.setPhoneNumber(phoneNumber);
            clientData.setEmailAddress(emailAddress);
            clientData.setDateofbirth(birthDate);
            clientData.setGender(gender);
            clientDao.update(clientData);

        } else {

            throw new RuntimeException("Client not found with username: " + userName);
        }
    }

public Optional<ClientDto> getClientByUserName(String userName) {
    Optional<ClientData> optionalClientData = clientDao.getClientByUsername(userName);

    if (optionalClientData.isPresent()) {
        ClientData clientData = optionalClientData.get();
        ClientDto clientDto = clientMapper.toDto(clientData);
        return Optional.of(clientDto);
    } else {
        return Optional.empty();
    }
}

    public List<ClientData> getAllClients() {
        return clientDao.getAll();
    }

        public Optional<ClientDto> getClientByUUID(UUID clientUUID) {
            Optional<ClientData> optionalClientData = clientDao.getClientByUUID(clientUUID);
            if (optionalClientData.isPresent()) {
                ClientData clientData = optionalClientData.get();
                ClientDto clientDto = clientMapper.toDto(clientData);
                return Optional.of(clientDto);
            } else {
                return Optional.empty();
            }
        }

    public void deleteClientByUserName(String userName) {
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

