package com.hospital.medical_record_service.service.impl;


import com.hospital.medical_record_service.dto.MedicalRecordRequest;
import com.hospital.medical_record_service.dto.MedicalRecordResponse;
import com.hospital.medical_record_service.entity.MedicalRecord;
import com.hospital.medical_record_service.repository.MedicalRecordRepository;
import com.hospital.medical_record_service.service.MedicalRecordService;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicalRecordServiceImpl 
        implements MedicalRecordService {


    private final MedicalRecordRepository repository;


    public MedicalRecordServiceImpl(
            MedicalRecordRepository repository) {

        this.repository = repository;
    }



    @Override
    public MedicalRecordResponse createRecord(
            MedicalRecordRequest request) {


        MedicalRecord record = MedicalRecord.builder()
                .patientId(request.getPatientId())
                .doctorId(request.getDoctorId())
                .diagnosis(request.getDiagnosis())
                .prescription(request.getPrescription())
                .recordDate(request.getRecordDate())
                .build();


        return mapToResponse(
                repository.save(record)
        );
    }



    @Override
    public List<MedicalRecordResponse> getRecords() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }



    @Override
    public MedicalRecordResponse getRecord(Long id) {


        MedicalRecord record =
                repository.findById(id)
                .orElseThrow(
                () -> new RuntimeException(
                "Medical record not found")
                );


        return mapToResponse(record);
    }



    @Override
    public List<MedicalRecordResponse> getRecordsByPatient(
            Long patientId) {


        return repository.findByPatientId(patientId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }



    @Override
    public List<MedicalRecordResponse> getRecordsByDoctor(
            Long doctorId) {


        return repository.findByDoctorId(doctorId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }



    @Override
    public MedicalRecordResponse updateRecord(
            Long id,
            MedicalRecordRequest request) {


        MedicalRecord record =
                repository.findById(id)
                .orElseThrow(
                () -> new RuntimeException(
                "Medical record not found")
                );


        record.setDiagnosis(request.getDiagnosis());

        record.setPrescription(request.getPrescription());

        record.setRecordDate(request.getRecordDate());


        return mapToResponse(
                repository.save(record)
        );
    }



    @Override
    public void deleteRecord(Long id) {

        repository.deleteById(id);

    }



    private MedicalRecordResponse mapToResponse(
            MedicalRecord record) {


        return MedicalRecordResponse.builder()
                .id(record.getId())
                .patientId(record.getPatientId())
                .doctorId(record.getDoctorId())
                .diagnosis(record.getDiagnosis())
                .prescription(record.getPrescription())
                .recordDate(record.getRecordDate())
                .build();
    }

}