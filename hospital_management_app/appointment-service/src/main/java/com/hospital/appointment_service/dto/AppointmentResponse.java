package com.hospital.appointment_service.dto;


import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponse {


    private Long id;

    private Long patientId;

    private Long doctorId;

    private LocalDateTime appointmentDate;

    private String status;

}