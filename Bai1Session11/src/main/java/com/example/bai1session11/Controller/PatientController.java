package com.example.bai1session11.Controller;

import com.example.bai1session11.Entity.Patient;
import com.example.bai1session11.Service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@Slf4j
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        log.info("Thêm bệnh nhân mới: {}", patient.getName());
        if (patient.getAge() != null && patient.getAge() > 120) {
            log.warn("Cảnh báo: Tuổi bệnh nhân quá cao: {} tuổi", patient.getAge());
        }
        Patient savedPatient = patientService.addPatient(patient);
        return ResponseEntity.ok(savedPatient);
    }
}
