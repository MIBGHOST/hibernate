package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Entity
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serverId;
    private String serverName;
    private String serverType;
//    @OneToOne(mappedBy = "server")
//    private Client client;
//    @OneToMany(mappedBy = "server")
//    private List<Client> clients;
    @ManyToMany(mappedBy = "servers")
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerType() {
        return serverType;
    }


    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public Server() {
    }

    public Server(String serverName, String serverType, List<Client> clients) {
        this.serverName = serverName;
        this.serverType = serverType;
        this.clients = clients;
    }

    public Server(String serverName, String serverType) {
        this.serverName = serverName;
        this.serverType = serverType;
    }

    @Override
    public String toString() {
        return "Server{" +
                "serverId=" + serverId +
                ", serverName='" + serverName + '\'' +
                ", serverType='" + serverType + '\'' +
                ", clients=" + clients +
                '}';
    }
}
