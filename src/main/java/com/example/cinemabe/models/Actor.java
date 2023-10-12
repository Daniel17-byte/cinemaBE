package com.example.cinemabe.models;

import lombok.*;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actors")
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "actor")
    private Set<ActorMovie> actorMovies = new HashSet<>();
}
