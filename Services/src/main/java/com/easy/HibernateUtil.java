package com.easy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Денис on 20.05.2016.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static {

        //creates the session factory from  hibernate.cfg.xml

        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void init() {

    }
}
