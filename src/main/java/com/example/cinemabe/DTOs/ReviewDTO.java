package com.example.cinemabe.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDTO {
    private String commentary;
    private int score;
    private Long movieId;
    private Long userId;
}
