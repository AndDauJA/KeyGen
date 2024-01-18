package lt.daujotas.service;


import lt.daujotas.clients.ClientLoginInfo;
import lt.daujotas.dao.ClientLoginDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ClientLoginService {

    private ClientLoginDao clientLoginDao;


    @Autowired
    public ClientLoginService (ClientLoginDao clientLoginDao){
        this.clientLoginDao=clientLoginDao;
    }

    public void saveLoginClient(ClientLoginInfo clientLoginInfo) {

        clientLoginDao.login(clientLoginInfo);
    }

//    public Page<ClientLoginPojo> getAllLoginClientsPages(Pageable pageable) {
//        return clientLoginDao.getPage(pageable);
//    }

}
