package com.practice.Healthcare.service.impl;
import com.practice.Healthcare.dto.AppointmentDTO;
import com.practice.Healthcare.dto.DoctorDTO;
import com.practice.Healthcare.dto.PatientDTO;
import com.practice.Healthcare.exception.ResourceNotFoundException;
import com.practice.Healthcare.model.Appointment;
import com.practice.Healthcare.model.AppointmentStatus;
import com.practice.Healthcare.model.Doctor;
import com.practice.Healthcare.model.Patient;
import com.practice.Healthcare.repository.AppointmentRepository;
import com.practice.Healthcare.repository.DoctorRepository;
import com.practice.Healthcare.repository.PatientRepository;
import com.practice.Healthcare.service.AdminService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public AdminServiceImpl(DoctorRepository doctorRepository, PatientRepository patientRepository,
                            AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctor -> {
                    DoctorDTO dto = new DoctorDTO();
                    dto.setId(doctor.getId());
                    dto.setName(doctor.getName());
                    dto.setEmail(doctor.getEmail());
                    dto.setSpecialization(doctor.getSpecialization());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patient -> {
                    PatientDTO dto = new PatientDTO();
                    dto.setId(patient.getId());
                    dto.setName(patient.getName());
                    dto.setEmail(patient.getEmail());
                    dto.setAddress(patient.getAddress());
                    dto.setPhone(patient.getPhone());
                    dto.setAge(patient.getAge());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(app -> {
                    AppointmentDTO dto = new AppointmentDTO();
                    dto.setId(app.getId());
                    dto.setDoctorId(app.getDoctor().getId());
                    dto.setPatientId(app.getPatient().getId());
                    dto.setAppointmentDate(app.getAppointmentDate());
                    dto.setStatus(app.getStatus());
                    return dto;
                }).collect(Collectors.toList());
    }
}
