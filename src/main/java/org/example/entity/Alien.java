package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

/*
* In order to create an entity we need minimum 2 requirements i,e. 1) @Entity and 2) @Id as identifier.
* We can use @Entity(name = "Alien") or any name we want give to our table.
* If our table name and entity name does not match then we need to explicitly mention the name using @Table(name="...").
* @Column(name = "..") --> if i need to change the name different from attribute name.
* when we annotate a class with @Entity , the ORM will create a Table with the name of our EntityClass.
* @Id is used make an attribute of a class as a primary key.
* attributes of the class are mapped as Columns in the db table. This is how object mapping is done.
*
*/
@Entity
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlien;
    private String alienName;
    private String alienType;
//    @OneToOne(mappedBy = "alien")
//    private Laptop laptop;
//    @OneToMany(mappedBy = "alien")
//    private List<Laptop> laptops;
    @ManyToMany(mappedBy = "aliens")
    private List<Laptop> laptops;


    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public int getIdAlien() {
        return idAlien;
    }

    public void setIdAlien(int idAlien) {
        this.idAlien = idAlien;
    }

    public String getAlienName() {
        return alienName;
    }

    public void setAlienName(String alienName) {
        this.alienName = alienName;
    }

    public String getAlienType() {
        return alienType;
    }

    public void setAlienType(String alienType) {
        this.alienType = alienType;
    }


    public Alien() {
    }

    public Alien(String alienName, String alienType) {
        this.alienName = alienName;
        this.alienType = alienType;
    }

    public Alien(String alienName, String alienType, List<Laptop> laptops) {
        this.alienName = alienName;
        this.alienType = alienType;
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "idAlien=" + idAlien +
                ", alienName='" + alienName + '\'' +
                ", alienType='" + alienType + '\'' +
                '}';
    }
}
