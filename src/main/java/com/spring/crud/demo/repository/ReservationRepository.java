package com.spring.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.crud.demo.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
}
