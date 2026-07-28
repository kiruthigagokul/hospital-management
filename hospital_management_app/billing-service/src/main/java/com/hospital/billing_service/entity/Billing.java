package com.hospital.billing_service.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name="billings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Billing {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable=false)
    private Long patientId;


    @Column(nullable=false)
    private Double amount;


    private LocalDate billingDate;


    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

}
