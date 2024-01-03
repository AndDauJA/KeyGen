package lt.daujotas.config;

import lt.daujotas.pojo.ClientAccountPojo;
import lt.daujotas.pojo.LoginCredentialsPojo;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    public static Configuration initConfiguration(){
        Configuration cfg=new Configuration();
        cfg.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        cfg.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/KeyGenerator");
        cfg.setProperty("hibernate.connection.username","KeyGenAdmin");
        cfg.setProperty("hibernate.connection.password","password");
        cfg.setProperty("hibernate.connection.autocommit","true");
        cfg.setProperty("hibernate.show_sql","true");
        cfg.setProperty("hibernate.hbm2ddl.auto","update");

        cfg.addAnnotatedClass(ClientAccountPojo.class);
        cfg.addAnnotatedClass(LoginCredentialsPojo.class);

       return cfg;
    }
}
