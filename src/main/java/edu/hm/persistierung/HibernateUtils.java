package edu.hm.persistierung;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate.
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * create.
     * @return s
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * shutdown.
     */
    public static void shutdown() {
        getSessionFactory().close();
    }
}