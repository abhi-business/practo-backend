package com.practo.doctorservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practo.doctorservice.model.Doctor;
import com.practo.doctorservice.repository.DoctorRepository;

@SpringBootApplication
public class DoctorserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DoctorRepository repo) {
		return args -> {
			if (repo.count() == 0) { // 👈 Avoid re-inserting every restart
				repo.save(Doctor.builder()
						.name("Dr. Sheelavathi Natraj")
						.speciality("Dermatologist")
						.experience(21)
						.location("JP Nagar")
						.clinic("Sapphire Skin And Aesthetics Clinic")
						.fees(800)
						.rating(94)
						.patientStories(1506)
						.availableToday(true)
						.build());
			}
		};
	}

}
