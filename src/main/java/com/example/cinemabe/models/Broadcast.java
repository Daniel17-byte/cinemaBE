package com.example.cinemabe.models;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "broadcasts")
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Broadcast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date date;

    @OneToMany(mappedBy = "broadcast")
    private Set<Reservation> reservations = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "movieIdFk"))
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "roomIdFk"))
    private Room room;

    public Broadcast(Date date, Movie movie, Room room) {
        this.date = date;
        this.movie = movie;
        this.room = room;
    }
}
