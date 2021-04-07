package com.spring.crud.demo.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Chambre implements Serializable {

    @Id
    @GeneratedValue
    private int idChambre;
    private String name;
    private double price;
    private String country;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Reservation reservation;



    public Chambre() {
        super();
    }

    public Chambre(int idChambre, String name, double price, String country, Hotel hotel) {
        this.idChambre = idChambre;
        this.name = name;
        this.price = price;
        this.country = country;
        this.hotel = hotel;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
