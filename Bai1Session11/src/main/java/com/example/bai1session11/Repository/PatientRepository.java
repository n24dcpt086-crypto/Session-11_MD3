package com.example.bai1session11.Repository;

import com.example.bai1session11.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
