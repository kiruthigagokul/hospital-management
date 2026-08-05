package com.hospital.billing_service.service;

import com.hospital.billing_service.dto.BillingRequest;
import com.hospital.billing_service.dto.BillingResponse;

import java.util.List;

public interface BillingService {

    // Create a new bill
    BillingResponse createBill(BillingRequest request);

    // Get all bills
    List<BillingResponse> getAllBills();

    // Get bill by ID
    BillingResponse getBillById(Long id);

    // Get all bills for a patient
    List<BillingResponse> getBillsByPatient(Long patientId);

    // Get bills by payment status
    List<BillingResponse> getBillsByStatus(String status);

    // Get bills for a patient filtered by status
    List<BillingResponse> getBillsByPatientAndStatus(
            Long patientId,
            String status);

    // Update payment status
    BillingResponse updatePaymentStatus(
            Long id,
            String status);

    // Delete bill
    void deleteBill(Long id);
}
