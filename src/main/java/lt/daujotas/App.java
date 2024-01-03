package lt.daujotas;

import lt.daujotas.config.HibernateConfig;
import lt.daujotas.config.HibernateDaoManager;
import lt.daujotas.pojo.ClientAccountPojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

nativeQueryExample();



        //Lorem ipsum - pasirinkti kiek zodziu
//        int fakeWordNumber = 5;
//        new LoremWordKeysGen().keyWordGen(fakeWordNumber);

        //GenerateChars.noOfRandChars = 1; // 1- viena raide+1 skaicius, 2- 2raides ir 2 skaiciai
//        GenerateSpecialKey.noOfRandChars = 1;                 // 1 - => 1 specraide ir simboli +1 skaicius arba spec simboli, etc
//
//        KeyGen.generateNoKey(3);
//        new SplashScreen();
//        try {
//            new PasswordManager(0);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        GenKeySaveToFile.fileOutGoing(0);
//      PasswEntrophyCalc.centrohyCalculator();
//        System.out.println(generatePassword(8));
    }

    private static void nativeQueryExample(){

        NativeQuery<ClientAccountPojo> query = getSession().createNativeQuery("SELECT * FROM clientaccount", ClientAccountPojo.class);
        List<ClientAccountPojo> clients = query.list();
        clients.forEach(System.out::println);
    }
    private static Session getSession(){
        return HibernateDaoManager.getSessnionFactory().openSession();
    }

}
