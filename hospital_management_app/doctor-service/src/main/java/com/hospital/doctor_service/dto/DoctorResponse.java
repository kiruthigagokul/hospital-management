package com.hospital.doctor_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponse {

    private Long id;

    private String name;

    private String email;

    private String specialization;

    private int experience;

    private boolean available;
}