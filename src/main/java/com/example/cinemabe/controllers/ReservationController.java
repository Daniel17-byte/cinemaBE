package com.example.cinemabe.controllers;

import com.example.cinemabe.models.Reservation;
import com.example.cinemabe.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok().body(reservationService.getAllReservations());
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation( @RequestBody Reservation reservation) {
        return ResponseEntity.ok().body(reservationService.saveReservation(reservation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reservation>> getReservationById(@PathVariable(value = "id") Long reservationId) {
        return ResponseEntity.ok().body(reservationService.getReservationById(reservationId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable(value = "id") Long reservationId, @RequestBody Reservation reservationDetails) {
        return ResponseEntity.ok().body(reservationService.updateReservation(reservationId, reservationDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable(value = "id") Long reservationId) {
        reservationService.deleteReservationById(reservationId);
        return ResponseEntity.ok().build();
    }
}