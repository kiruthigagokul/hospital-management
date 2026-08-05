package com.hospital.appointment_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name="appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable=false)
    private Long patientId;


    @Column(nullable=false)
    private Long doctorId;


    @Column(nullable=false)
    private LocalDateTime appointmentDate;


    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;


}