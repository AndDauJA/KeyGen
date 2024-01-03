package lt.daujotas.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDaoManager {


    public static SessionFactory getSessnionFactory() {

        Configuration cfg = HibernateConfig.initConfiguration();
        return cfg.buildSessionFactory();


    }


}
