package com.practice.Healthcare.repository;
import com.practice.Healthcare.model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
