package com.spring.crud.demo.service;


import com.spring.crud.demo.model.Reservation;
import jdk.vm.ci.meta.Local;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {

    List<Reservation> getAll();

    List<Reservation> getAllIncomingReservations();

    void cancelReservation(int idReservation);

    Reservation saveReservation(Reservation reservation);


    boolean checkIfAvailable(int idChambre, LocalDateTime startDate, LocalDateTime endDate);

}
