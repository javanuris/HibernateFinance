package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 04.07.2017.
 */
public class HibernateUtil {

    public static final SessionFactory  sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            return configuration.configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
