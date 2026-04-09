package com.practice.Healthcare.controller;
import com.practice.Healthcare.dto.MedicalRecordDTO;
import com.practice.Healthcare.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService recordService;


    @PostMapping
    public MedicalRecordDTO addRecord(@RequestBody MedicalRecordDTO dto) {
        return recordService.addRecord(dto);
    }

    @GetMapping
    public List<MedicalRecordDTO> getAllRecords() {
        return recordService.getAllRecords();
    }


    @GetMapping("/{id}")
    public MedicalRecordDTO getRecordById(@PathVariable Long id) {
        return recordService.getRecordById(id);
    }


    @GetMapping("/patient/{patientId}")
    public List<MedicalRecordDTO> getRecordsByPatient(@PathVariable Long patientId) {
        return recordService.getRecordsByPatient(patientId);
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return "Medical record deleted successfully";
    }
}
