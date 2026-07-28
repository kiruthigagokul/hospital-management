package com.hospital.medical_record_service.controller;


import com.hospital.medical_record_service.dto.MedicalRecordRequest;
import com.hospital.medical_record_service.dto.MedicalRecordResponse;
import com.hospital.medical_record_service.service.MedicalRecordService;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medical-records")
public class MedicalRecordController {


    private final MedicalRecordService service;


    public MedicalRecordController(
            MedicalRecordService service) {

        this.service = service;
    }



    @PostMapping
    public MedicalRecordResponse createRecord(
            @RequestBody MedicalRecordRequest request) {

        return service.createRecord(request);
    }



    @GetMapping
    public List<MedicalRecordResponse> getRecords(){

        return service.getRecords();
    }



    @GetMapping("/{id}")
    public MedicalRecordResponse getRecord(
            @PathVariable Long id){

        return service.getRecord(id);
    }



    @GetMapping("/patient/{patientId}")
    public List<MedicalRecordResponse> getPatientRecords(
            @PathVariable Long patientId){

        return service.getRecordsByPatient(patientId);
    }



    @GetMapping("/doctor/{doctorId}")
    public List<MedicalRecordResponse> getDoctorRecords(
            @PathVariable Long doctorId){

        return service.getRecordsByDoctor(doctorId);
    }



    @PutMapping("/{id}")
    public MedicalRecordResponse updateRecord(
            @PathVariable Long id,
            @RequestBody MedicalRecordRequest request){

        return service.updateRecord(id, request);
    }



    @DeleteMapping("/{id}")
    public String deleteRecord(
            @PathVariable Long id){

        service.deleteRecord(id);

        return "Medical record deleted";
    }

}