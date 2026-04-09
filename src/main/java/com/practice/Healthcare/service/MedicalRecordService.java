package com.practice.Healthcare.service;
import com.practice.Healthcare.dto.MedicalRecordDTO;


import java.util.List;

public interface MedicalRecordService {

    MedicalRecordDTO addRecord(MedicalRecordDTO dto);

    List<MedicalRecordDTO> getRecordsByPatient(Long patientId);

    List<MedicalRecordDTO> getAllRecords();

    MedicalRecordDTO getRecordById(Long id);

    void deleteRecord(Long id);
}
