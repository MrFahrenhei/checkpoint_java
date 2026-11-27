package com.beraldo.checkpointjava.persistence.entity;

import com.beraldo.checkpointjava.enums.BookingStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime start;

    private LocalDateTime ending;

    // não apagar registros ou dados do DB, manter um histórico, por isso é um status para indicar quando ocorreu cancelamentos
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    // uma reserva tem um responsável por ela
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // uma reserve existe em uma sala
    @ManyToOne(fetch = FetchType.LAZY)
    // para não criar reserva com sala em null
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    // protected aqui para o jpa poder usar
    protected Reservation(){}

    public Reservation(Room room, User user, LocalDateTime start, LocalDateTime ending){
        if(!room.isRoomAvailableToUse()){
            throw new IllegalArgumentException("Sala está ocupada");
        }
        // para rejeitar antes ou igual
        if(!ending.isAfter(start)){
            throw new IllegalArgumentException("Fim deve ser depois de iniciar sala");
        }
        this.user = user;
        this.start = start;
        this.ending = ending;
        this.room = room;
        this.status = BookingStatus.ACTIVE;
    }

    public void cancelReservation(){
        if(status == BookingStatus.CANCELLED){
            throw new IllegalStateException("Reserva já cancelada");
        }
        this.status = BookingStatus.CANCELLED;
    }

    public boolean isActive(){
        return status == BookingStatus.ACTIVE;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnding() {
        return ending;
    }

    public Room getRoom() {
        return room;
    }

    public boolean conflictWith(Reservation newReservation){
        if(!Objects.equals(this.room.getId(), newReservation.room.getId())) {
            return false;
        }

        if(!this.isActive() || !newReservation.isActive()) {
            return false;
        }
        // primeira reserva começa antes da nova terminar e a nova começa antes de a terminar
        boolean isFree = this.start.isBefore(newReservation.ending) && newReservation.start.isBefore(this.ending);

        return isFree;

    }
}
