package com.example.cinemabe.services;

import com.example.cinemabe.models.ActorMovie;
import com.example.cinemabe.repositories.ActorMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorMovieService {
    @Autowired
    private ActorMovieRepository actorMovieRepository;

    public ActorMovie saveActorMovie(ActorMovie actorMovie) {
        return actorMovieRepository.save(actorMovie);
    }

    public Optional<ActorMovie> getActorMovieById(Long id) {
        return actorMovieRepository.findById(id);
    }

    public ActorMovie updateActorMovie(Long id, ActorMovie actorMovie) {
        return actorMovieRepository.saveAndFlush(actorMovie);
    }

    public void deleteActorMovieById(Long id) {
        actorMovieRepository.deleteById(id);
    }

    public List<ActorMovie> getAllActorMovies() {
        return actorMovieRepository.findAll();
    }
}