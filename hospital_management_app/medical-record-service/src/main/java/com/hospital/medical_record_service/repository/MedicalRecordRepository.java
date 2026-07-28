package com.hospital.medical_record_service.repository;


import com.hospital.medical_record_service.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MedicalRecordRepository 
        extends JpaRepository<MedicalRecord, Long> {


    List<MedicalRecord> findByPatientId(Long patientId);


    List<MedicalRecord> findByDoctorId(Long doctorId);

}