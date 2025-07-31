package com.practo.doctorservice.repository;

import com.practo.doctorservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByLocationAndSpeciality(String location, String speciality);
}
