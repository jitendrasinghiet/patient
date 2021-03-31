package com.playzone.patient.service;

import java.util.List;

import com.playzone.patient.entity.Patient;

public interface PatientService {
	
	List<Patient> search(String query);
	List<Patient> getAll();
	Patient getByID(Long id);
	Patient create(Patient p);
	void update(Patient p, Long id);
	void delete(Long id);

}
