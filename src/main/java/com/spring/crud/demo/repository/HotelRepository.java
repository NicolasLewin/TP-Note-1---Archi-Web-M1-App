package com.spring.crud.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.crud.demo.model.Chambre;
import com.spring.crud.demo.model.Hotel;
import com.spring.crud.demo.model.Reservation;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	@Query("SELECT SUM(r.priceReservation) FROM Reservation r")
	public double getTotalCA();
	
	@Query("SELECT SUM(r.priceReservation) FROM Reservation r WHERE MONTH(r.endDate) =: indexMonth")
	public double getTotalCAForMonth(@Param("indexMonth") int indexMonth);
	
	@Query("SELECT r FROM Reservation r WHERE DATE(r.startDate) =: date")
	public List<Reservation> getReservationsFromDate( @Param("date") LocalDate date);
	
	@Query("SELECT c FROM Chambre c WHERE DATE(c.reservations.startDate) <> date")
	public List<Chambre> getChambresWithoutReservationInDate(@Param("date") LocalDate date);

}
