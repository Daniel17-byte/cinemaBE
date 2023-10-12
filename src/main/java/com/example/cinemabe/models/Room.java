package com.example.cinemabe.models;

import lombok.*;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rooms")
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int seats;
    private String location;

    @OneToMany(mappedBy = "room")
    private Set<Broadcast> broadcasts = new HashSet<>();

    public Room(int seats, String location) {
        this.seats = seats;
        this.location = location;
    }
}
