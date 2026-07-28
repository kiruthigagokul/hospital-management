package com.hospital.doctor_service.service.impl;

import com.hospital.doctor_service.dto.DoctorRequest;
import com.hospital.doctor_service.dto.DoctorResponse;
import com.hospital.doctor_service.entity.Doctor;
import com.hospital.doctor_service.repository.DoctorRepository;
import com.hospital.doctor_service.service.DoctorService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {


    private final DoctorRepository repository;


    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }


    @Override
    public DoctorResponse createDoctor(DoctorRequest request) {

        Doctor doctor = Doctor.builder()
                .name(request.getName())
                .email(request.getEmail())
                .specialization(request.getSpecialization())
                .experience(request.getExperience())
                .available(request.isAvailable())
                .build();


        Doctor savedDoctor = repository.save(doctor);


        return mapToResponse(savedDoctor);
    }



    @Override
    public List<DoctorResponse> getAllDoctors() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }



    @Override
    public DoctorResponse getDoctorById(Long id) {

        Doctor doctor = repository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException("Doctor not found")
                );

        return mapToResponse(doctor);
    }



    @Override
    public void deleteDoctor(Long id) {

        repository.deleteById(id);

    }



    private DoctorResponse mapToResponse(Doctor doctor) {

        return DoctorResponse.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .email(doctor.getEmail())
                .specialization(doctor.getSpecialization())
                .experience(doctor.getExperience())
                .available(doctor.isAvailable())
                .build();
    }
}
