package com.beraldo.checkpointjava.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // capacidade de pessoas
    private int capacity;

    private String name;

    // o status para dizer se a sala está disponível para qualquer agenda
    private boolean status;

    // Uma sala pode ter várias reservas
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservationsList;

    // protected para o jpa usar
    protected Room(){}

    public Room(String name, int capacity){
        if(capacity<=0){
            throw new IllegalArgumentException("capacity should be greater than 0 (zero)");
        }
        this.name = name;
        this.capacity = capacity;
        this.status = true;
    }

    public boolean isRoomAvailableToUse(){ return status; }
    public void deactivate() { this.status = false;}
    public void activate() { this.status = true;}

    public Long getId() {
        return id;
    }
}
