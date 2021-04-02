package com.playzone.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.playzone.medicine.dto.Medicine;
import com.playzone.medicine.remote.MedicineOperations;

import feign.Feign;

@SpringBootApplication(scanBasePackages = { "com.playzone" })
@EnableEurekaClient
@EnableFeignClients(basePackageClasses = {MedicineOperations.class,Medicine.class})
public class PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}
	
	@Bean	
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}
	
}
