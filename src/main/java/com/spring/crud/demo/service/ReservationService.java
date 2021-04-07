package com.spring.crud.demo.service;


import com.spring.crud.demo.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {

    List<Reservation> getAll();

    List<Reservation> getAllIncomingReservations();

    void cancelReservation(int idReservation);




    /*
    TrainStation getTrainStationById(int stationId);

    TrainStation save(TrainStation trainStation);

    TrainStation update(int id, TrainStation trainStation);

    void delete(int id);

     */
}
