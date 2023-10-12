package com.example.cinemabe.services;

import com.example.cinemabe.models.Broadcast;
import com.example.cinemabe.repositories.BroadcastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BroadcastService {
    @Autowired
    private BroadcastRepository broadcastRepository;

    public Broadcast saveBroadcast(Broadcast broadcast) {
        return broadcastRepository.save(broadcast);
    }

    public Optional<Broadcast> getBroadcastById(Long id) {
        return broadcastRepository.findById(id);
    }

    public Broadcast updateBroadcast(Long id, Broadcast broadcast) {
        return broadcastRepository.saveAndFlush(broadcast);
    }

    public Optional<Broadcast> deleteBroadcastById(Long id) {
        broadcastRepository.deleteById(id);
        return null;
    }

    public List<Broadcast> getAllBroadcast() {
        return broadcastRepository.findAll();
    }
}