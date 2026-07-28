package com.hospital.billing_service.dto;


import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillingResponse {


    private Long id;

    private Long patientId;

    private Double amount;

    private LocalDate billingDate;

    private String status;

}