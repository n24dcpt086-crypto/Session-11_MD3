package com.example.bai2session11.Service;

import com.example.bai2session11.Entity.Patient;
import com.example.bai2session11.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients() {

        log.trace("Bắt đầu lấy danh sách bệnh nhân");

        List<Patient> patients = patientRepository.findAll();

        log.trace("Đã tìm thấy {} bệnh nhân", patients.size());

        return patients;
    }
    public List<Patient> searchPatients(String name) {

        log.trace("Bắt đầu tìm kiếm bệnh nhân với tên: {}", name);

        List<Patient> patients =
                patientRepository.findByNameContainingIgnoreCase(name);

        log.trace("Kết thúc tìm kiếm. Số lượng kết quả: {}", patients.size());

        return patients;
    }
}
