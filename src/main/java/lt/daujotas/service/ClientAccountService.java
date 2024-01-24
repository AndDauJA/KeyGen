package lt.daujotas.service;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lt.daujotas.clients.ClientLoginInfo;
import lt.daujotas.dao.ClientDao;
import lt.daujotas.clients.ClientAccountInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Service
public class ClientAccountService {


    private ClientDao clientDao;
    private final ClientLoginService clientLoginService;



    @Autowired
    public ClientAccountService(ClientDao clientDao,ClientLoginService clientLoginService) {
        this.clientDao = clientDao;
        this.clientLoginService = clientLoginService;
    }

    public void saveClient(ClientAccountInfo clientAccountInfo) {

        clientDao.save(clientAccountInfo);
    }
    public void saveClientWithLoginInfo(ClientAccountInfo clientAccountInfo, ClientLoginInfo clientLoginInfo) {
        // Saugome kliento informaciją
        clientDao.save(clientAccountInfo);

        // Priskiriame kliento informaciją prisijungimo informacijai
        clientLoginInfo.setClientAccountInfo(clientAccountInfo);

        // Saugome prisijungimo informaciją
        clientLoginService.saveLoginClient(clientLoginInfo);
    }



    public void updateClient(ClientAccountInfo clientAccountInfo) {

        ClientAccountInfo clientAccountInfo1= clientDao.getClientByUUID(clientAccountInfo.getAccountUuid()).get();
        clientAccountInfo1.setPhoneNumber(clientAccountInfo.getPhoneNumber());
        clientDao.save(clientAccountInfo1);
    }

    public void getClientByName(ClientAccountInfo clientAccountInfo) {

    }

    public List<ClientAccountInfo> getAllClients() {
        return clientDao.getAll();
    }

    public Optional<ClientAccountInfo> getClientByUUID(UUID id) {
        return clientDao.getClientByUUID(id);
    }
    public Optional<ClientAccountInfo> getClientByFirstName(String firstName) {
        return clientDao.getClientByFirstName(firstName);
    }
    public void deleteClientByUUID(UUID id) {
        clientDao.deleteClientByUUID(id);
    }

    public Page<ClientAccountInfo> getAllClientsPages(Pageable pageable) {
        return clientDao.getPage(pageable);
    }


    }

