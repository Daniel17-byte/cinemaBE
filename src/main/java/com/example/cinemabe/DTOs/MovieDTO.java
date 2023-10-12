package com.example.cinemabe.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDTO {
    private String description;
    private String image;
    private Long categoryId;
    private Long genreId;
    private Long userId;
}
