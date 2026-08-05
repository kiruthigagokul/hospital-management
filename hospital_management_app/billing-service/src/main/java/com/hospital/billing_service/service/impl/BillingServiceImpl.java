package com.hospital.billing_service.service.impl;

import com.hospital.billing_service.dto.BillingRequest;
import com.hospital.billing_service.dto.BillingResponse;
import com.hospital.billing_service.entity.Billing;
import com.hospital.billing_service.entity.PaymentStatus;
import com.hospital.billing_service.repository.BillingRepository;
import com.hospital.billing_service.service.BillingService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    private final BillingRepository repository;

    public BillingServiceImpl(BillingRepository repository) {
        this.repository = repository;
    }

    @Override
    public BillingResponse createBill(BillingRequest request) {

        Billing billing = Billing.builder()
                .patientId(request.getPatientId())
                .amount(request.getAmount())
                .billingDate(request.getBillingDate())
                .status(PaymentStatus.PENDING)
                .build();

        Billing saved = repository.save(billing);

        return mapToResponse(saved);
    }

    @Override
    public List<BillingResponse> getAllBills() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public BillingResponse getBillById(Long id) {

        Billing billing = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Bill not found"));

        return mapToResponse(billing);
    }

    @Override
    public List<BillingResponse> getBillsByPatient(Long patientId) {

        return repository.findByPatientId(patientId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<BillingResponse> getBillsByStatus(String status) {

        PaymentStatus paymentStatus =
                PaymentStatus.valueOf(status.toUpperCase());

        return repository.findByStatus(paymentStatus)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<BillingResponse> getBillsByPatientAndStatus(
            Long patientId,
            String status) {

        PaymentStatus paymentStatus =
                PaymentStatus.valueOf(status.toUpperCase());

        return repository.findByPatientIdAndStatus(
                        patientId,
                        paymentStatus)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public BillingResponse updatePaymentStatus(
            Long id,
            String status) {

        Billing billing = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Bill not found"));

        billing.setStatus(
                PaymentStatus.valueOf(status.toUpperCase()));

        Billing updated = repository.save(billing);

        return mapToResponse(updated);
    }

    @Override
    public void deleteBill(Long id) {

        repository.deleteById(id);
    }

    private BillingResponse mapToResponse(Billing billing) {

        return BillingResponse.builder()
                .id(billing.getId())
                .patientId(billing.getPatientId())
                .amount(billing.getAmount())
                .billingDate(billing.getBillingDate())
                .status(billing.getStatus().name())
                .build();
    }
}
