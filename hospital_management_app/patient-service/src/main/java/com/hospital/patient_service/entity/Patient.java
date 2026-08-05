package com.hospital.patient_service.entity;


import jakarta.persistence.*;

import lombok.*;


@Entity
@Table(name="patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private int age;


    private String gender;


    private String email;


    private String phone;


    private String address;


}