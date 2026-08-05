package com.hospital.medical_record_service.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name="medical_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRecord {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private Long patientId;


    @Column(nullable = false)
    private Long doctorId;


    @Column(nullable = false)
    private String diagnosis;


    @Column(length = 1000)
    private String prescription;


    private LocalDate recordDate;

}