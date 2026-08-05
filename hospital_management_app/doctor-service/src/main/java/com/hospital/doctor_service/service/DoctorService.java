package com.hospital.doctor_service.service;

import com.hospital.doctor_service.dto.DoctorRequest;
import com.hospital.doctor_service.dto.DoctorResponse;

import java.util.List;

public interface DoctorService {

    DoctorResponse createDoctor(DoctorRequest request);

    List<DoctorResponse> getAllDoctors();

    DoctorResponse getDoctorById(Long id);

    void deleteDoctor(Long id);
}