package com.spring.crud.demo.controller;

import java.util.List;

import com.spring.crud.demo.model.Reservation;
import com.spring.crud.demo.repository.ReservationRepository;
import com.spring.crud.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    









    /*
    @GetMapping("/{id}")
    public Reservation getStudentById(@PathVariable int id ) {
        return reservationService.getTrainStationById(id);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Reservation trainStation) {
        Reservation savedTrainStation = reservationService.save(trainStation);
        return ResponseEntity.ok().body(savedTrainStation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Reservation trainStation) {
        Reservation updatedTrainStation = reservationService.update(id, trainStation);
        return ResponseEntity.ok().body(updatedTrainStation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        reservationService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully");
    }


     */
}