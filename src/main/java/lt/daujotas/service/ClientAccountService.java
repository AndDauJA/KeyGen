package lt.daujotas.service;



import lt.daujotas.dao.ClientDao;
import lt.daujotas.clients.ClientAccountPojo;
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

    public void saveClient(ClientAccountPojo clientAccountPojo) {

        clientDao.save(clientAccountPojo);
    }


    public void updateClient(ClientAccountPojo clientAccountPojo) {
        clientDao.update(clientAccountPojo);
    }

    public List<ClientAccountPojo> getAllClients() {
        return clientDao.getAll();
    }

    public Optional<ClientAccountPojo> getClientByUUID(UUID id) {
        return clientDao.getClientByUUID(id);
    }

    public void deleteClientByUUID(UUID id) {
        clientDao.deleteClientByUUID(id);
    }

    public Page<ClientAccountPojo> getAllClientsPages(Pageable pageable) {
        return clientDao.getPage(pageable);
    }

}
