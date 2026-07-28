package com.hospital.appointment_service.dto;

import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentRequest {


    private Long patientId;

    private Long doctorId;

    private LocalDateTime appointmentDate;

}