package com.example.cinemabe.models;

import lombok.*;
import org.hibernate.annotations.Cascade;

import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "userIdFkk"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "broadcast_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "broadcastIdFk"))
    private Broadcast broadcast;

    public Reservation(User user, Broadcast broadcast) {
        this.user = user;
        this.broadcast = broadcast;
    }
}
