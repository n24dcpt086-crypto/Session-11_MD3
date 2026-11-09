package com.example.bai3session11.Service;

import com.example.bai3session11.Entity.Patient;
import com.example.bai3session11.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {
    private final PatientRepository patientRepository;
    public Patient addPatient(Patient patient) {

        log.info("Bat dau them benh nhan");

        Patient savedPatient = patientRepository.save(patient);

        log.info("Them benh nhan thanh cong");

        return savedPatient;
    }
    public List<Patient> getAllPatients() {

        log.info("Bat dau lay danh sach benh nhan");

        List<Patient> patients = patientRepository.findAll();

        log.info("Lay danh sach benh nhan thanh cong");

        return patients;
    }
    public List<Patient> searchPatients(String name) {

        log.info("Bat dau tim kiem benh nhan");

        List<Patient> patients =
                patientRepository.findByNameContainingIgnoreCase(name);

        log.info("Tim kiem benh nhan hoan tat");

        return patients;
    }
}
