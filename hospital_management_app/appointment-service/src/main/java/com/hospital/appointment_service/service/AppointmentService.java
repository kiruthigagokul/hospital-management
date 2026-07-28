package com.hospital.appointment_service.service;


import com.hospital.appointment_service.dto.AppointmentRequest;
import com.hospital.appointment_service.dto.AppointmentResponse;

import java.util.List;


public interface AppointmentService {


    AppointmentResponse createAppointment(
            AppointmentRequest request);


    List<AppointmentResponse> getAppointments();


    AppointmentResponse getAppointment(Long id);


    void cancelAppointment(Long id);

}
