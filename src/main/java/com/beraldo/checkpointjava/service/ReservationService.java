package com.beraldo.checkpointjava.service;

import com.beraldo.checkpointjava.persistence.entity.Reservation;
import com.beraldo.checkpointjava.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    // não usei autowired para escrever testes
    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Reservation add(Reservation newReservation){
        if(repository.conflictWith(newReservation.getRoom().getId(), newReservation.getStart(), newReservation.getEnding())){
            throw new IllegalStateException("Reservation already taken");
        }
        return repository.save(newReservation);
    }
}