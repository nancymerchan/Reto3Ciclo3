package com.usa.reto3.web;

import com.usa.reto3.model.Reservation;
import com.usa.reto3.service.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nbsc1
 */
@RestController
@RequestMapping("/api/Reservation")
public class ReservationWeb {

    @Autowired
    private ReservationService servicios;

    @GetMapping("/all")
    public List<Reservation> getReservations() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return servicios.getReservation(reservationId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return servicios.save(reservation);
    }

}
