package com.example.cinemabe.services;

import com.example.cinemabe.models.Actor;
import com.example.cinemabe.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Optional<Actor> getActorById(Long id) {
        return actorRepository.findById(id);
    }

    public Actor updateActor(Long id, Actor actor) {
        Actor existingActor = actorRepository.getOne(id);
        existingActor.setFirstName(actor.getFirstName());
        existingActor.setLastName(actor.getLastName());
        return actorRepository.saveAndFlush(existingActor);
    }

    public void deleteActorById(Long id) {
        actorRepository.deleteById(id);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }
}