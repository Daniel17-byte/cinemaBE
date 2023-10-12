package com.example.cinemabe.DTOs;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BroadcastDTO {
    private Date date;
    private Long movieId;
    private Long roomId;
}
