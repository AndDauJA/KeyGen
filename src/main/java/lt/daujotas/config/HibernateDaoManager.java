package lt.daujotas.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDaoManager {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessnionFactory() {
        if (sessionFactory == null) {
            sessionFactory = HibernateConfig.initConfiguration().buildSessionFactory();
        }
        return sessionFactory;


    }


}
