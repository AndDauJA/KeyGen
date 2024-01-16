package lt.daujotas.dao;


import lt.daujotas.clients.ClientLoginPojo;
import lt.daujotas.clients.ClientLoginRepository;
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
    public void login(ClientLoginPojo clientLoginPojo) {
        clientLoginRepository.save(clientLoginPojo);

    }
}
