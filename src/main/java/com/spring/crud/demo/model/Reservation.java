package com.spring.crud.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

	@ManyToMany
	@JoinTable(name = "reservation_personnes", joinColumns = @JoinColumn(name = "idReservation"), inverseJoinColumns = @JoinColumn(name = "idPersonne"))
	private List<Personne> personne;

	@ManyToOne
	private Chambre chambre;

	public Reservation() {
		super();
	}

	public Reservation(LocalDateTime startDate, LocalDateTime endDate, double priceReservation, boolean status,
			Chambre chambre, List<Personne> personne) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceReservation = priceReservation;
		this.status = status;
		this.chambre = chambre;
		this.personne = personne;
	}

	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public double getPriceReservation() {
		return priceReservation;
	}

	public void setPriceReservation(double priceReservation) {
		this.priceReservation = priceReservation;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Personne> getPersonne() {
		return personne;
	}

	public void setPersonne(List<Personne> personne) {
		this.personne = personne;
	}

}
