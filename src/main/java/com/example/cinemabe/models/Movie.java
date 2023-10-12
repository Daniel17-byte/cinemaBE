package com.example.cinemabe.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private String image;


    @OneToMany(mappedBy = "movie")
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private Set<Broadcast> broadcasts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "categoryIdFk"))
    private Category category;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "genreIdFk"))
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "userIdFk"))
    private User user;

    @OneToMany(mappedBy = "movie")
    private Set<ActorMovie> actorMovies = new HashSet<>();

    public Movie(String name, String description, Category category, Genre genre, User user) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.genre = genre;
        this.user = user;
    }
}
