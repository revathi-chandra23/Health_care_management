package com.practice.Healthcare.service.impl;
import com.practice.Healthcare.dto.MedicalRecordDTO;
import com.practice.Healthcare.exception.ResourceNotFoundException;

import com.practice.Healthcare.model.Doctor
;
import com.practice.Healthcare.model.MedicalRecord;
import com.practice.Healthcare.model.Patient;
import com.practice.Healthcare.repository.DoctorRepository;
import com.practice.Healthcare.repository.MedicalRecordRepository;
import com.practice.Healthcare.repository.PatientRepository;
import com.practice.Healthcare.service.MedicalRecordService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private MedicalRecordRepository recordRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public MedicalRecordDTO addRecord(MedicalRecordDTO dto) {
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        MedicalRecord record = new MedicalRecord();
        record.setPatient(patient);
        record.setDoctor(doctor);
        record.setDiagnosis(dto.getDiagnosis());
        record.setPrescription(dto.getPrescription());
        record.setNotes(dto.getNotes());
        record.setCreatedAt(LocalDateTime.now());

        MedicalRecord saved = recordRepository.save(record);

        return mapToDTO(saved);
    }

    @Override
    public List<MedicalRecordDTO> getRecordsByPatient(Long patientId) {
        return recordRepository.findByPatientId(patientId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalRecordDTO> getAllRecords() {
        return recordRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicalRecordDTO getRecordById(Long id) {
        MedicalRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
        return mapToDTO(record);
    }

    @Override
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }

    private MedicalRecordDTO mapToDTO(MedicalRecord record) {
        MedicalRecordDTO dto = new MedicalRecordDTO();
        dto.setId(record.getId());
        dto.setPatientId(record.getPatient().getId());
        dto.setDoctorId(record.getDoctor().getId());
        dto.setDiagnosis(record.getDiagnosis());
        dto.setPrescription(record.getPrescription());
        dto.setNotes(record.getNotes());
        dto.setCreatedAt(record.getCreatedAt());
        return dto;
    }
}
