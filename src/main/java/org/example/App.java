package org.example;

import org.example.entity.Alien;
import org.example.entity.Laptop;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class App
{
    public static void main( String[] args )
    {
        /*
        * create a configuration(it is a class , which help to bootstrap your hibernate).
        * help in configuring the dataSource.
        */
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        //initialize the session object
        /*
        * we can create as many sessions as we want and make them do different-2 tasks.
        * session is short-lived
        * basically creating session means asking for a new connection.
        * session is the api which interact with the database.
        */
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();/* this is required as to achieve the consistency,
                                                                and it is used to make changes in the db.
                                                                this allows us to begin, commit and rollBack transactions.*/

        //creating an object filled with data.

        //OneToOne
        /*
        Laptop lap1 = new Laptop("Mac");
        Laptop lap2 = new Laptop("Dell");
        Laptop lap3 = new Laptop("sony");

        Alien a1 = new Alien("mib", "human");
        Alien a2 = new Alien("ghost", "human");
        Alien a3 = new Alien("marshal", "animal");

        lap1.setAlien(a1);
        lap2.setAlien(a2);
        lap3.setAlien(a3);
        */

        //OneToMany and ManyToOne
        /*
        Laptop lap1 = new Laptop("Mac");
        Laptop lap2 = new Laptop("Dell");
        Laptop lap3 = new Laptop("sony");

        List<Laptop> laptops = Arrays.asList(lap1,lap2);
        List<Laptop> laptops1 = Collections.singletonList(lap3);

        Alien a1 = new Alien("mib", "human");
        Alien a2 = new Alien("ghost", "human");

        lap1.setAlien(a1);
        lap2.setAlien(a2);
        lap3.setAlien(a1);
        */

        //ManyToMany
        /*
        Laptop lap1 = new Laptop("Mac");
        Laptop lap2 = new Laptop("Dell");
        Laptop lap3 = new Laptop("sonyV");

        List<Laptop> laptops = Arrays.asList(lap1,lap2);
        List<Laptop> laptops1 = Collections.singletonList(lap3);

        Alien a1 = new Alien("mib", "human",laptops);
        Alien a2 = new Alien("ghost", "human", laptops);
        Alien a3 = new Alien("marshal", "animal", laptops1);

        List<Alien> aliens = Arrays.asList(a1, a3);
        List<Alien> aliens1 = Collections.singletonList(a2);

        lap1.setAliens(aliens);
        lap2.setAliens(aliens1);
        lap3.setAliens(aliens);
         */


        /* CREATE DATA */
//        session.persist(lap1);
//        session.persist(lap2);
//        session.persist(lap3);
//
//        session.persist(a1);
//        session.persist(a2);
//        session.persist(a3);

        /* READ DATA */
//        Alien alien = session.get(Alien.class, 1);
//        System.out.println(alien);
//        Laptop laptop = session.get(Laptop.class, 1);
//        System.out.println(laptop);

        /* UPDATE DATA */
//        Laptop laptop = session.get(Laptop.class, 3);
//        laptop.setAlien(null);
//        session.persist(laptop);

        /* DELETE DATA */
        /* here I want to delete a row from the db and for that I need to get that from the entity and its
        PK using get() method and this returns the persistent instance of the given entityClass and with identifier,
        and then we have the remove() method in session which takes that object and remove it.
         */
//        Alien alien = session.get(Alien.class, 3);
//        session.remove(alien);


        /*
        * .commit() method is used to make the changes visible.
        * .close() method is used to close the connection that was being opened.
        * if this connection is not being closed then we may run into resource insufficiency issue or
        * may leads to connection leak issue.
        */

        transaction.commit();
        session.close();
    }
}
