package com.example.bai2session11.Repository;

import com.example.bai2session11.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContainingIgnoreCase(String name);
}
