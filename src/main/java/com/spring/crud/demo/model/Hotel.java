package com.spring.crud.demo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Hotel implements Serializable {

    @Id
    @GeneratedValue
    private int idHotel;
    private String name;
    private String adresse;

    @OneToMany(mappedBy = "idChambre")
    private List<Chambre> chambres;

    public Hotel() {
        super();
    }

    public Hotel(String name, String adresse, List<Chambre> chambres) {
        this.name = name;
        this.adresse = adresse;
        this.chambres = chambres;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }
}
