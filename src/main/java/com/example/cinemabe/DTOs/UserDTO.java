package com.example.cinemabe.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String email;
    private String firstName;
    private String lastName;
    boolean isAdmin;
    boolean isEmployee;
    private String phoneNumber;
}
