package com.hospital.doctor_service.repository;

import com.hospital.doctor_service.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository 
        extends JpaRepository<Doctor, Long> {

}