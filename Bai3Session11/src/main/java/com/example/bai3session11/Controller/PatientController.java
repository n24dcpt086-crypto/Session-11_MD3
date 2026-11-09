package com.example.bai3session11.Controller;

import com.example.bai3session11.Entity.Patient;
import com.example.bai3session11.Service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@Slf4j
public class PatientController {
    private final PatientService patientService;
    @PostMapping
    public ResponseEntity<Patient> addPatient(
            @RequestBody Patient patient) {

        log.info("API them benh nhan duoc goi");

        Patient savedPatient =
                patientService.addPatient(patient);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedPatient);
    }
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {

        log.info("API lay danh sach benh nhan duoc goi");

        List<Patient> patients =
                patientService.getAllPatients();

        return ResponseEntity.ok(patients);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatients(
            @RequestParam String name) {

        log.info("API tim kiem benh nhan duoc goi");

        List<Patient> patients =
                patientService.searchPatients(name);

        return ResponseEntity.ok(patients);
    }
}
