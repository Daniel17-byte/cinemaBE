package com.example.cinemabe.repositories;

import com.example.cinemabe.models.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorMovieRepository extends JpaRepository<ActorMovie, Long> {
}