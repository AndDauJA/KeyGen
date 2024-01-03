package lt.daujotas.dao;

import lt.daujotas.pojo.ClientAccountPojo;
import org.hibernate.Session;

import java.util.List;

public class ClientAccountDao {

    private final Session session;


    public ClientAccountDao(Session session) {
        this.session = session;
    }

    //Read
    public List<ClientAccountPojo> getAll() {

        return session.createQuery("FROM ClientAccountPojo", ClientAccountPojo.class).list();
    }

    public ClientAccountPojo getOneById(Long id) {
        return session.get(ClientAccountPojo.class, id);
    }

    //Create and Save
    public void creat(ClientAccountPojo clientAccountPojo) {
        session.merge(clientAccountPojo);
    }

    public void delete(ClientAccountPojo clientAccountPojo) {  //trina visa objekta
        session.remove(clientAccountPojo);
    }

    public void deleteById(Long id) {  //trina pagal pasirnkta kriteriju
        ClientAccountPojo clientAccountPojo=getOneById(id);
        if(getOneById(id)!=null){
            session.remove(clientAccountPojo);
        }
    }

}
