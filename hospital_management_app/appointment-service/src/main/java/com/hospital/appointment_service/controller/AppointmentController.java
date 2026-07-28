package com.hospital.appointment_service.controller;


import com.hospital.appointment_service.dto.AppointmentRequest;
import com.hospital.appointment_service.dto.AppointmentResponse;
import com.hospital.appointment_service.service.AppointmentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {


    private final AppointmentService service;


    public AppointmentController(
            AppointmentService service) {

        this.service = service;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponse createAppointment(
            @Valid @RequestBody AppointmentRequest request) {

        return service.createAppointment(request);
    }



    @GetMapping
    public List<AppointmentResponse> getAppointments() {

        return service.getAppointments();
    }



    @GetMapping("/{id}")
    public AppointmentResponse getAppointment(
            @PathVariable Long id) {

        return service.getAppointment(id);
    }



    @PutMapping("/{id}/cancel")
    public String cancelAppointment(
            @PathVariable Long id) {

        service.cancelAppointment(id);

        return "Appointment cancelled";
    }

}