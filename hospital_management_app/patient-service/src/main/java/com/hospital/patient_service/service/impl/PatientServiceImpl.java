package com.hospital.patient_service.service.impl;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.hospital.patient_service.dto.PatientRequest;
import com.hospital.patient_service.dto.PatientResponse;
import com.hospital.patient_service.entity.Patient;
import com.hospital.patient_service.repository.PatientRepository;
import com.hospital.patient_service.service.PatientService;


import java.util.List;


@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;


    @Override
    public PatientResponse createPatient(PatientRequest request) {


        Patient patient = Patient.builder()
                .name(request.getName())
                .age(request.getAge())
                .gender(request.getGender())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .build();


        Patient savedPatient =
                patientRepository.save(patient);


        return mapToResponse(savedPatient);
    }


    @Override
    public List<PatientResponse> getAllPatients() {

        return patientRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }


    @Override
    public PatientResponse getPatientById(Long id) {


        Patient patient =
                patientRepository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException("Patient not found")
                );


        return mapToResponse(patient);

    }


    @Override
    public PatientResponse updatePatient(
            Long id,
            PatientRequest request) {


        Patient patient =
                patientRepository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException("Patient not found")
                );


        patient.setName(request.getName());
        patient.setAge(request.getAge());
        patient.setGender(request.getGender());
        patient.setEmail(request.getEmail());
        patient.setPhone(request.getPhone());
        patient.setAddress(request.getAddress());


        return mapToResponse(
                patientRepository.save(patient)
        );

    }


    @Override
    public void deletePatient(Long id) {

        patientRepository.deleteById(id);

    }



    private PatientResponse mapToResponse(Patient patient){


        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .age(patient.getAge())
                .gender(patient.getGender())
                .email(patient.getEmail())
                .phone(patient.getPhone())
                .address(patient.getAddress())
                .build();

    }

}