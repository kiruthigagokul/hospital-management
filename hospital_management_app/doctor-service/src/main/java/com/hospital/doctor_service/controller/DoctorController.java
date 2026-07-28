package com.hospital.doctor_service.controller;

import com.hospital.doctor_service.dto.DoctorRequest;
import com.hospital.doctor_service.dto.DoctorResponse;
import com.hospital.doctor_service.service.DoctorService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/doctors")
public class DoctorController {


    private final DoctorService doctorService;


    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    // Create Doctor
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorResponse createDoctor(
            @Valid @RequestBody DoctorRequest request) {

        return doctorService.createDoctor(request);
    }



    // Get All Doctors
    @GetMapping
    public List<DoctorResponse> getAllDoctors() {

        return doctorService.getAllDoctors();
    }



    // Get Doctor By ID
    @GetMapping("/{id}")
    public DoctorResponse getDoctorById(
            @PathVariable Long id) {

        return doctorService.getDoctorById(id);
    }



    // Delete Doctor
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(
            @PathVariable Long id) {

        doctorService.deleteDoctor(id);
    }

}