package com.practo.doctorservice.controller;

import com.practo.doctorservice.model.Doctor;
import com.practo.doctorservice.repository.DoctorRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorRepository repo;

    public DoctorController(DoctorRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Doctor> getDoctors(
            @RequestParam String location,
            @RequestParam String speciality) {
        return repo.findByLocationAndSpeciality(location, speciality);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
