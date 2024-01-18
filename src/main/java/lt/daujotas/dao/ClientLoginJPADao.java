package lt.daujotas.dao;


import lt.daujotas.clients.ClientLoginInfo;
import lt.daujotas.clients.repositories.ClientLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientLoginJPADao implements ClientLoginDao{

    ClientLoginRepository clientLoginRepository;

    @Autowired
    public ClientLoginJPADao (ClientLoginRepository clientLoginRepository){
        this.clientLoginRepository=clientLoginRepository;
    }
    @Override
    public void login(ClientLoginInfo clientLoginInfo) {
        clientLoginRepository.save(clientLoginInfo);

    }
}
