package com.hospital.patient_service.controller;


import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.hospital.patient_service.dto.PatientRequest;
import com.hospital.patient_service.dto.PatientResponse;
import com.hospital.patient_service.service.PatientService;


import java.util.List;


@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {


    private final PatientService patientService;



    // Create Patient
    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(
            @RequestBody PatientRequest request) {


        return new ResponseEntity<>(
                patientService.createPatient(request),
                HttpStatus.CREATED
        );

    }



    // Get All Patients
    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {


        return ResponseEntity.ok(
                patientService.getAllPatients()
        );

    }



    // Get Patient By Id
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(
            @PathVariable Long id) {


        return ResponseEntity.ok(
                patientService.getPatientById(id)
        );

    }



    // Update Patient
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(
            @PathVariable Long id,
            @RequestBody PatientRequest request) {


        return ResponseEntity.ok(
                patientService.updatePatient(id, request)
        );

    }



    // Delete Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(
            @PathVariable Long id) {


        patientService.deletePatient(id);


        return ResponseEntity.ok(
                "Patient deleted successfully"
        );

    }

}