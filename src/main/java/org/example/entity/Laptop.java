package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lId;
    private String lName;
//    @OneToOne
//    private Alien alien;
//    @ManyToOne
//    private Alien alien;
    @ManyToMany
    private List<Alien> aliens;

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Laptop(int lId, String lName) {
        this.lId = lId;
        this.lName = lName;
    }

    public Laptop() {
    }

    public Laptop(String lName) {
        this.lName = lName;
    }

    public Laptop(List<Alien> aliens, String lName) {
        this.aliens = aliens;
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lId=" + lId +
                ", lName='" + lName + '\'' +
                '}';
    }
}
