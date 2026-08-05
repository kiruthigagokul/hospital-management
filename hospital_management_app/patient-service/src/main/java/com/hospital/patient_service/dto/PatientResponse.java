package com.hospital.patient_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponse {


    private Long id;

    private String name;

    private int age;

    private String gender;

    private String email;

    private String phone;

    private String address;

}