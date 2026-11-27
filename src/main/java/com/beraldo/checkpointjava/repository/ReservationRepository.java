package com.beraldo.checkpointjava.repository;

import com.beraldo.checkpointjava.persistence.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("""
        SELECT COUNT(r) > 0 FROM Reservation r
        WHERE r.room.id = :roomId
          AND r.status = 'ACTIVE'
          AND r.start < :ending
          AND :start < r.ending
        """)
    boolean conflictWith(Long roomId, LocalDateTime start, LocalDateTime ending);
}
