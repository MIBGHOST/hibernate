package org.example.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//singleton design pattern for SessionFactory

public class HibernateUtils {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration configuration = getConfiguration();

            //create session factory(session factory is just a data source)
            /*
             * This session-factory must be created only once in our project until unless we
             * don't have more than one dataSources or databases.
             * sessionFactory is long-lived.
             * this is the legacy way to create session-factory.we have better way to do so.
             */
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");/* we don't need to specify the resource file
                                                            name explicitly to configure() as if this
                                                            file(hibernate.cfg.xml) will be fetched from
                                                            src/main/resources automatically.
                                                            we have to specify the file name explicitly if we have named it
                                                            other than standard name i,e. hibernate.cfg.xml .
                                                          */
        return configuration;
    }
}
