package com.hospital.medical_record_service.service;


import com.hospital.medical_record_service.dto.MedicalRecordRequest;
import com.hospital.medical_record_service.dto.MedicalRecordResponse;

import java.util.List;


public interface MedicalRecordService {


    // Create new medical record
    MedicalRecordResponse createRecord(
            MedicalRecordRequest request);



    // Get all medical records
    List<MedicalRecordResponse> getRecords();



    // Get single record by ID
    MedicalRecordResponse getRecord(
            Long id);



    // Get all records of a patient
    List<MedicalRecordResponse> getRecordsByPatient(
            Long patientId);



    // Get all records created by a doctor
    List<MedicalRecordResponse> getRecordsByDoctor(
            Long doctorId);



    // Update existing medical record
    MedicalRecordResponse updateRecord(
            Long id,
            MedicalRecordRequest request);



    // Delete medical record
    void deleteRecord(
            Long id);

}