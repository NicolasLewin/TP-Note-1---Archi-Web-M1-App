package com.spring.crud.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	@ManyToMany
	private List<Chambre> reservations = new ArrayList<Chambre>();

	public Personne(String firstName, String lastName, char sex, int age, List<Chambre> reservations) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.age = age;
		this.reservations = reservations;
	}

	public Personne() {
		super();
	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Chambre> getReservations() {
		return reservations;
	}

	public void setReservations(List<Chambre> reservations) {
		this.reservations = reservations;
	}

}
