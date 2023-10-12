package com.example.cinemabe.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int score;
    private String commentary;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "userIdFkkk"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "movieIdFkkk"))
    private Movie movie;
}
