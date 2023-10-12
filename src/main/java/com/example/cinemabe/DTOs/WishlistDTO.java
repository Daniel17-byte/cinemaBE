package com.example.cinemabe.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WishlistDTO {
    private String name;
    private Long userId;
}
