package com.example.bai2session11.Controller;

import com.example.bai2session11.Entity.Patient;
import com.example.bai2session11.Service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@Slf4j
public class PatientController {
    private final PatientService patientService;
    @GetMapping
    public List<Patient> getAllPatients() {

        log.info("API lấy danh sách bệnh nhân được gọi");

        return patientService.getAllPatients();
    }
    @GetMapping("/search")
    public List<Patient> searchPatients(@RequestParam String name) {

        log.info("API tìm kiếm bệnh nhân được gọi");

        return patientService.searchPatients(name);
    }
}
