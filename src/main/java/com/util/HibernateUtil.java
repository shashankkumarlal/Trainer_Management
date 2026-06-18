package com.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {
    private static final SessionFactory factory = buildSessionFactory();

    public static SessionFactory buildSessionFactory(){ // Dependent on Builder Design Pattern
        try{
            return new Configuration().configure().buildSessionFactory();
        } catch(Throwable ex){
            System.out.println("initial creation failed");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){ // Singleton Design Pattern -> only returns one object and only once it is invoked and runs throughtout
        return factory;
    }

    public static void shutdown(){
        getSessionFactory();
    }
}
