package com.spring.crud.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.spring.crud.demo.model.Reservation;
import com.spring.crud.demo.repository.ReservationRepository;
import com.spring.crud.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationRepository repository;

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping
    public List<Reservation> getAllIncomingReservations() {
        return reservationService.getAllIncomingReservations();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> cancelReservation(@PathVariable int id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.ok().body(repository.findById(id).get());
    }

    @PostMapping("/book")
    public ResponseEntity<?> saveReservation(@RequestParam(name = "idChambre") int idChambre,
                                             @RequestParam(name = "startDate") LocalDateTime startDate,
                                             @RequestParam(name = "endDate") LocalDateTime endDate,
                                             @RequestBody Reservation reservation) {

        Reservation savedReservation = null;
        try {

            if(!repository.findById(idChambre).isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'id de la chambre n'existe pas");
            }
            reservationService.checkIfAvailable(idChambre, startDate, endDate);
            savedReservation = reservationService.saveReservation(reservation);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erreur d'insertion");
        }
        return ResponseEntity.ok().body(savedReservation);
    }

}