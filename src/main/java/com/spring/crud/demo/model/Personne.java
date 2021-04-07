package com.spring.crud.demo.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Personne implements Serializable {

    @Id
    @GeneratedValue
    private int idPersonne;
    private String firstName;
    private String lastName;
    private char sex;
    private int age;

    @ManyToOne
    private Reservation reservation;


}
