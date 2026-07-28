package com.hospital.billing_service.repository;

import com.hospital.billing_service.entity.Billing;
import com.hospital.billing_service.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingRepository extends JpaRepository<Billing, Long> {

    List<Billing> findByPatientId(Long patientId);

    List<Billing> findByStatus(PaymentStatus status);

    List<Billing> findByPatientIdAndStatus(Long patientId, PaymentStatus status);
}