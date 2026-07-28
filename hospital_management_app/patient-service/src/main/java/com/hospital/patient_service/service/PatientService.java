package com.hospital.patient_service.service;


import com.hospital.patient_service.dto.PatientRequest;
import com.hospital.patient_service.dto.PatientResponse;

import java.util.List;


public interface PatientService {


    PatientResponse createPatient(PatientRequest request);


    List<PatientResponse> getAllPatients();


    PatientResponse getPatientById(Long id);


    PatientResponse updatePatient(Long id, PatientRequest request);


    void deletePatient(Long id);


}