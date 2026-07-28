package com.hospital.appointment_service.service.impl;


import com.hospital.appointment_service.dto.AppointmentRequest;
import com.hospital.appointment_service.dto.AppointmentResponse;
import com.hospital.appointment_service.entity.Appointment;
import com.hospital.appointment_service.entity.AppointmentStatus;
import com.hospital.appointment_service.repository.AppointmentRepository;
import com.hospital.appointment_service.service.AppointmentService;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {


    private final AppointmentRepository repository;


    public AppointmentServiceImpl(AppointmentRepository repository) {
        this.repository = repository;
    }


    @Override
    public AppointmentResponse createAppointment(
            AppointmentRequest request) {


        Appointment appointment = Appointment.builder()
                .patientId(request.getPatientId())
                .doctorId(request.getDoctorId())
                .appointmentDate(request.getAppointmentDate())
                .status(AppointmentStatus.BOOKED)
                .build();


        Appointment savedAppointment =
                repository.save(appointment);


        return mapToResponse(savedAppointment);
    }



    @Override
    public List<AppointmentResponse> getAppointments() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }



    @Override
    public AppointmentResponse getAppointment(Long id) {


        Appointment appointment =
                repository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException(
                        "Appointment not found")
                );


        return mapToResponse(appointment);
    }



    @Override
    public void cancelAppointment(Long id) {


        Appointment appointment =
                repository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException(
                        "Appointment not found")
                );


        appointment.setStatus(
                AppointmentStatus.CANCELLED
        );


        repository.save(appointment);
    }



    private AppointmentResponse mapToResponse(
            Appointment appointment) {


        return AppointmentResponse.builder()
                .id(appointment.getId())
                .patientId(appointment.getPatientId())
                .doctorId(appointment.getDoctorId())
                .appointmentDate(
                        appointment.getAppointmentDate()
                )
                .status(
                        appointment.getStatus().name()
                )
                .build();
    }

}