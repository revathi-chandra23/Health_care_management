package com.practice.Healthcare.service;
import com.practice.Healthcare.dto.AppointmentDTO;
import com.practice.Healthcare.dto.DoctorDTO;
import com.practice.Healthcare.dto.PatientDTO;


import java.util.List;

public interface AdminService {
    List<DoctorDTO> getAllDoctors();
    List<PatientDTO> getAllPatients();
    List<AppointmentDTO> getAllAppointments();
}
