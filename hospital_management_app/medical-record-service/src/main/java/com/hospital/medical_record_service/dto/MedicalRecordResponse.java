package com.hospital.medical_record_service.dto;


import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRecordResponse {


    private Long id;

    private Long patientId;

    private Long doctorId;

    private String diagnosis;

    private String prescription;

    private LocalDate recordDate;

}