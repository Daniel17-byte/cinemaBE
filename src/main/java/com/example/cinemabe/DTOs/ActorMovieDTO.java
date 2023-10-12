package com.example.cinemabe.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActorMovieDTO {
    private Long actorId;
    private Long movieId;
}
