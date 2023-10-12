package com.example.cinemabe.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTO {
    private Long broadcastId;
    private Long userId;
}
