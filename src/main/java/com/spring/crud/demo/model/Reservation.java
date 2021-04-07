package com.spring.crud.demo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table
public class Reservation implements Serializable {

    @Id
    @GeneratedValue
    private int idReservation;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double priceReservation;
    private boolean status;

    @ManyToOne
    private Personne personne;

}
