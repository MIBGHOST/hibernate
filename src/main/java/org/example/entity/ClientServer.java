package org.example.entity;

import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class ClientServer {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        Server s1 = new Server("WebServer", "Web");
        Server s2 = new Server("DNSServer", "DNS");

        List<Server> servers = Arrays.asList(s1,s2);

        Client c1 = new Client(servers, "mib");
        Client c2 = new Client(servers, "Ghost");

        List<Client> clients = Arrays.asList(c1,c2);

        s1.setClients(clients);
        s2.setClients(clients);

        Transaction tx = session.beginTransaction();

//        session.persist(s1);
//        session.persist(s2);
//        System.out.println("Servers are being saved in db!");
//
//        session.persist(c1);
//        session.persist(c2);
//        System.out.println("Client are being saved in db!");

        Server server = session.get(Server.class, 1);
        System.out.println(server.getServerName());
        System.out.println(server.getServerType());

        tx.commit();
        session.close();
    }
}
