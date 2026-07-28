package com.hospital.doctor_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable=false)
    private String name;


    @Column(nullable=false,unique=true)
    private String email;


    @Column(nullable=false)
    private String specialization;


    private int experience;


    private boolean available;

}