package com.practo.doctorservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String speciality;
    private int experience;
    private String location;
    private String clinic;
    private int fees;
    private int rating;
    private int patientStories;
    private boolean availableToday;
}
