package lt.daujotas.service;


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


    @Autowired
    public ClientAccountService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void saveClient(ClientAccountInfo clientAccountInfo) {

        clientDao.save(clientAccountInfo);
    }


    public void updateClient(ClientAccountInfo clientAccountInfo) {
        clientDao.update(clientAccountInfo);
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

