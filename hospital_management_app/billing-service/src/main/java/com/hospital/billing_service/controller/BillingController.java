package com.hospital.billing_service.controller;

import com.hospital.billing_service.dto.BillingRequest;
import com.hospital.billing_service.dto.BillingResponse;
import com.hospital.billing_service.service.BillingService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    // Create Bill
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BillingResponse createBill(
            @Valid @RequestBody BillingRequest request) {

        return billingService.createBill(request);
    }

    // Get All Bills
    @GetMapping
    public List<BillingResponse> getAllBills() {

        return billingService.getAllBills();
    }

    // Get Bill By Id
    @GetMapping("/{id}")
    public BillingResponse getBillById(
            @PathVariable Long id) {

        return billingService.getBillById(id);
    }

    // Get Bills By Patient
    @GetMapping("/patient/{patientId}")
    public List<BillingResponse> getBillsByPatient(
            @PathVariable Long patientId) {

        return billingService.getBillsByPatient(patientId);
    }

    // Get Bills By Status
    @GetMapping("/status/{status}")
    public List<BillingResponse> getBillsByStatus(
            @PathVariable String status) {

        return billingService.getBillsByStatus(status);
    }

    // Get Bills By Patient And Status
    @GetMapping("/patient/{patientId}/status/{status}")
    public List<BillingResponse> getBillsByPatientAndStatus(
            @PathVariable Long patientId,
            @PathVariable String status) {

        return billingService.getBillsByPatientAndStatus(
                patientId,
                status);
    }

    // Update Payment Status
    @PutMapping("/{id}/status/{status}")
    public BillingResponse updatePaymentStatus(
            @PathVariable Long id,
            @PathVariable String status) {

        return billingService.updatePaymentStatus(
                id,
                status);
    }

    // Delete Bill
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBill(
            @PathVariable Long id) {

        billingService.deleteBill(id);
    }

}