//package lt.daujotas.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Value("jdbc:mysql://localhost:3306/KeyGenerator")
//    private String url;
//
//    @Value("KeyGenAdmin")
//    private String username;
//
//    @Value("password")
//    private String password;
//
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/KeyGenerator");
//        dataSource.setUsername("KeyGenAdmin");
//        dataSource.setPassword("password");
//        return dataSource;
//    }
//
//}
