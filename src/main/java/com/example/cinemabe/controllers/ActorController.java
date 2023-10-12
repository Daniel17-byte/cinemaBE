package com.example.cinemabe.controllers;

import com.example.cinemabe.models.Actor;
import com.example.cinemabe.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors() {
        List<Actor> actors = actorService.getAllActors();
        return ResponseEntity.ok(actors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Actor>> getActorById(@PathVariable Long id) {
        Optional<Actor> actor = actorService.getActorById(id);
        return ResponseEntity.ok(actor);
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        Actor savedActor = actorService.saveActor(actor);
        return ResponseEntity.ok(savedActor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable Long id, @RequestBody Actor actorDetails) {
        Actor updatedActor = actorService.updateActor(id, actorDetails);
        return ResponseEntity.ok(updatedActor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorService.deleteActorById(id);
        return ResponseEntity.noContent().build();
    }
}