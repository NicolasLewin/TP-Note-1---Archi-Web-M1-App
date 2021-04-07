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

	@ManyToOne
	private Hotel hotel;

	@ManyToOne
	private Reservation reservations;

	public Chambre() {
		super();
	}

	public Chambre(String name, double price, Hotel hotel) {
		this.name = name;
		this.price = price;
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Reservation getReservations() {
		return reservations;
	}

	public void setReservations(Reservation reservations) {
		this.reservations = reservations;
	}

}
