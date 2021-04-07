package com.spring.crud.demo.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.spring.crud.demo.model.Reservation;
import com.spring.crud.demo.repository.ReservationRepository;
import com.spring.crud.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository repository;

    @PersistenceContext
    private EntityManager entityManger;

    @Override
    public List<Reservation> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Reservation> getAllIncomingReservations() {
        List<Reservation> reservations = repository.getIncomingReservations(LocalDate.now());
        return reservations;
    }

    @Override
    public void cancelReservation(int idReservation) {
        repository.cancelReservation(idReservation);
    }





    /*
    @Override
    public TrainStation getTrainStationById(int trainStationId) {
        List<TrainStation> trainStations = repository.findAll();
        for (TrainStation trainStation : trainStations) {
            if (trainStationId == trainStation.getTrainStationId())
                return trainStation;
        }
        return null;
    }

    @Override
    public TrainStation save(TrainStation trainStation) {
        return repository.save(trainStation);
    }

    @Override
    public TrainStation update(int id, TrainStation trainStation) {
        if(!repository.existsById(id) ) return null;

        trainStation.setTrainStationId(id);
        return repository.save(trainStation);
    }

    @Override
    public void delete(int id) {
        if(repository.existsById(id) ) {
            repository.deleteById(id);
        }
    }

     */

}
