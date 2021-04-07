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

    @Query("UPDATE Reservation r SET r.status = false WHERE r.idReservation = :idReservation")
    void cancelReservation(@Param("idReservation") int idReservation);

    /*
    @Query("SELECT j FROM Journey j WHERE j.departureStation.trainStationId= :stationDepart AND j.arrivalStation.trainStationId= :stationArrival ORDER BY j.departureDate")
    List<Reservation> getJourneysOfDestinations(@Param("stationDepart") int stationDepart, @Param("stationArrival") int stationArrival);


    @Query("SELECT j FROM Journey j WHERE j.departureStation.trainStationId= :stationDepart")
    List<Reservation> getJourneysAverageByStation(@Param("stationDepart") int stationDepart);

    @Modifying
    @Query("DELETE FROM Journey j WHERE j.departureStation.trainStationId= :station OR j.arrivalStation.trainStationId= :station")
    void deleteJourneysOfStation(@Param("station") int station);

     */
}
