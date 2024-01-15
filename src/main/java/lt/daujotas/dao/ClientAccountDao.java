//package lt.daujotas.dao;
//
//import com.mysql.cj.xdevapi.SessionFactory;
//import lt.daujotas.clients.ClientAccountPojo;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//@Repository
//public class ClientAccountDao {
//
//    private final SessionFactory sessionFactory;
//
//    @Autowired
//    public ClientAccountDao(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//
//    //Read
//    public List<ClientAccountPojo> getAll() {
//
//        try (Session session = sessionFactory.getSession()) {
//            return session.createQuery("FROM ClientAccountPojo", ClientAccountPojo.class).list();
//    }
//
////    public Optional<ClientAccountPojo> getOneById(Long id) {
////        return Optional.ofNullable(sessionFactory.get(ClientAccountPojo.class, id));
////    }
//
//
//
//    public void persist(ClientAccountPojo clientAccountPojo) {
////        clientAccountPojo.setUuid(UUID.randomUUID());
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.merge(clientAccountPojo);
//            session.getTransaction().commit();
//        }
//
//        public void delete (ClientAccountPojo clientAccountPojo) {
//            try (Session session = sessionFactory.openSession()) {
//                session.beginTransaction();
//                session.remove(clientAccountPojo);
//                session.getTransaction().commit();
//            }
//        }
//
//    public void deleteById(Long id) {  //trina pagal pasirnkta kriteriju
//        getOneById(id).ifPresent(obj->session.remove(obj));
//
//    }
//
//}
