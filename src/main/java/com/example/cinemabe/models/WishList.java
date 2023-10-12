package com.example.cinemabe.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wishlists")
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "userIdFkkkk"))
    private User user;
}
