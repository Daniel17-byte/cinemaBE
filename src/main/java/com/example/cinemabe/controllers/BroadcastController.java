package com.example.cinemabe.controllers;

import com.example.cinemabe.models.Broadcast;
import com.example.cinemabe.services.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/broadcasts")
public class BroadcastController {

    @Autowired
    private BroadcastService broadcastService;

    @GetMapping
    public ResponseEntity<List<Broadcast>> getAllBroadcasts() {
        List<Broadcast> broadcasts = broadcastService.getAllBroadcast();
        return ResponseEntity.ok(broadcasts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Broadcast>> getBroadcastById(@PathVariable Long id) {
        Optional<Broadcast> broadcast = broadcastService.getBroadcastById(id);
        return ResponseEntity.ok(broadcast);
    }

    @PostMapping
    public ResponseEntity<Broadcast> createBroadcast(@RequestBody Broadcast broadcast) {
        Broadcast newBroadcast = broadcastService.saveBroadcast(broadcast);
        return ResponseEntity.ok(newBroadcast);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Broadcast> updateBroadcast(@PathVariable Long id, @RequestBody Broadcast broadcast) {
        Broadcast updatedBroadcast = broadcastService.updateBroadcast(id, broadcast);
        return ResponseEntity.ok(updatedBroadcast);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBroadcast(@PathVariable Long id) {
        broadcastService.deleteBroadcastById(id);
        return ResponseEntity.ok().build();
    }
}