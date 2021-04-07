package com.spring.crud.demo.repository;

import com.spring.crud.demo.model.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository for reservation
 * @author NicolasLewin
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT r FROM Reservation r WHERE DATE(r.startDate) >= :today")
    List<Reservation> getIncomingReservations(@Param("today") LocalDate today);

    @Query("SELECT r FROM Reservation r WHERE DATE(r.startDate) >= :start and DATE(r.endDate) >= :end AND r.chambre.idChambre =:idChambre ")
    List<Reservation> getReservationBetweenDateForChambre(@Param("start") LocalDate start, @Param("end") LocalDate end, @Param("idChambre") int idChambre );
    
    @Query("UPDATE Reservation r SET r.status = false WHERE r.idReservation = :idReservation")
    void cancelReservation(@Param("idReservation") int idReservation);
    
    @Query("SELECT SUM(r.priceReservation) FROM Reservation r")
	public double getTotalCA();
	
	@Query("SELECT SUM(r.priceReservation) FROM Reservation r WHERE MONTH(r.endDate) =: indexMonth")
	public double getTotalCAForMonth(@Param("indexMonth") int indexMonth);
	
	@Query("SELECT r FROM Reservation r WHERE DATE(r.startDate) =: date")
	public List<Reservation> getReservationsFromDate( @Param("date") LocalDate date);
}
