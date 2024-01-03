package lt.daujotas.dao;

import lt.daujotas.pojo.ClientAccountPojo;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ClientAccountDao {

    private final Session session;


    public ClientAccountDao(Session session) {
        this.session = session;
    }

    //Read
    public List<ClientAccountPojo> getAll() {

        return session.createQuery("FROM ClientAccountPojo", ClientAccountPojo.class).list();
    }

    public Optional<ClientAccountPojo> getOneById(Long id) {
        return Optional.ofNullable(session.get(ClientAccountPojo.class, id));
    }

    //Create and Save
    public void creat(ClientAccountPojo clientAccountPojo) {
        session.merge(clientAccountPojo);
    }

    public void delete(ClientAccountPojo clientAccountPojo) {  //trina visa objekta
        session.remove(clientAccountPojo);
    }

    public void deleteById(Long id) {  //trina pagal pasirnkta kriteriju
        getOneById(id).ifPresent(obj->session.remove(obj));

    }

}
