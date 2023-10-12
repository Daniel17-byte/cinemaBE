package com.example.cinemabe.controllers;

import com.example.cinemabe.models.ActorMovie;
import com.example.cinemabe.services.ActorMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actor_movies")
public class ActorMovieController {
    @Autowired
    private ActorMovieService actorMovieService;

    @GetMapping
    public ResponseEntity<List<ActorMovie>> getAllActorMovies() {
        return ResponseEntity.ok(actorMovieService.getAllActorMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ActorMovie>> getActorMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(actorMovieService.getActorMovieById(id));
    }

    @PostMapping
    public ResponseEntity<ActorMovie> createActorMovie(@RequestBody ActorMovie actorMovie) {
        return ResponseEntity.ok(actorMovieService.saveActorMovie(actorMovie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorMovie> updateActorMovie(@PathVariable Long id, @RequestBody ActorMovie actorMovie) {
        return ResponseEntity.ok(actorMovieService.updateActorMovie(id, actorMovie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActorMovie(@PathVariable Long id) {
        actorMovieService.deleteActorMovieById(id);
        return ResponseEntity.noContent().build();
    }
}