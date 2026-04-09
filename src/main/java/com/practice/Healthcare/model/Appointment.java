package com.practice.Healthcare.model;

    import jakarta.persistence.*;
    import java.time.LocalDate;

    @Entity
    @Table(name = "appointments")
    public class Appointment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "doctor_id", nullable = false)
        private Doctor doctor;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "patient_id", nullable = false)
        private Patient patient;

        @Column(name = "appointment_date", nullable = false)
        private LocalDate appointmentDate;

        @Column(nullable = false)
        private String status;


        public Appointment() {
        }

        public Appointment(Doctor doctor, Patient patient, LocalDate appointmentDate, String status) {
            this.doctor = doctor;
            this.patient = patient;
            this.appointmentDate = appointmentDate;
            this.status = status;
        }



        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Doctor getDoctor() {
            return doctor;
        }

        public void setDoctor(Doctor doctor) {
            this.doctor = doctor;
        }

        public Patient getPatient() {
            return patient;
        }

        public void setPatient(Patient patient) {
            this.patient = patient;
        }

        public LocalDate getAppointmentDate() {
            return appointmentDate;
        }

        public void setAppointmentDate(LocalDate appointmentDate) {
            this.appointmentDate = appointmentDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
