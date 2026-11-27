package com.beraldo.checkpointjava.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    // um usuário pode ter várias reservas feita no nome dele
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservationList;

    public User(String nome, String email){
        if(nome.isBlank()){
            throw new IllegalArgumentException("Name can not be empty");
        }
        this.name = nome;
        this.email = email;
    }

    // protected para o jpa poder usar
    protected User() { }
}
