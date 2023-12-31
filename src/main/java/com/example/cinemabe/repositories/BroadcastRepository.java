package com.example.cinemabe.repositories;

import com.example.cinemabe.models.Broadcast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadcastRepository extends JpaRepository<Broadcast, Long> {
}