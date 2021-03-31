package com.playzone.patient.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.playzone.patient.entity.Patient;

@RequestMapping("/patient")
public interface PatientOperations {

	@GetMapping("/search")
    public List<Patient> search(@RequestParam(value = "query") String search);

	@GetMapping("")
	public List<Patient> retrieveAllPatients();

	@GetMapping("/{id}")
	public Patient retrievePatient(@PathVariable long id);
	
	@GetMapping("/{id}/medicine")
	public Patient retrievePatientMedicine(@PathVariable long id);

	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable long id);

	@PostMapping("")
	public ResponseEntity<Object> createPatient(@RequestBody Patient patient);
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePatient(@RequestBody Patient patient, @PathVariable long id);
	
}
