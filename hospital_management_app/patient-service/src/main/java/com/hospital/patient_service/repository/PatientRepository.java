package com.hospital.patient_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.patient_service.entity.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {


}