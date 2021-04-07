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

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return repository.save(reservation);
    }


    @Override
    public boolean checkIfAvailable(int idChambre, LocalDateTime startDate, LocalDateTime endDate) {
    	List<Reservation> reservations =  repository.getReservationBetweenDateForChambre(startDate.toLocalDate(), endDate.toLocalDate(), idChambre);
		return reservations.isEmpty();
    }

}
