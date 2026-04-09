package com.practice.Healthcare.service;
import com.practice.Healthcare.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {

    AppointmentDTO bookAppointment(AppointmentDTO appointmentDTO);

    List<AppointmentDTO> getAppointmentsForPatient(Long patientId);

    List<AppointmentDTO> getAppointmentsForDoctor(Long doctorId);

    AppointmentDTO updateAppointmentStatus(Long appointmentId, String status);
    List<AppointmentDTO> getAllAppointments();
    void cancelAppointment(Long appointmentId);
}
