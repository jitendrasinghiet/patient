package com.playzone.patient.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.playzone.medicine.remote.MedicineOperations;
import com.playzone.patient.entity.Patient;
import com.playzone.patient.service.PatientService;

@RestController
public class PatientController implements PatientOperations{

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private MedicineOperations medicineOperations;
		
	@Override
    public List<Patient> search(@RequestParam(value = "query") String search) {
        return patientService.search(search);
    }

	@Override
	public List<Patient> retrieveAllPatients() {
		return patientService.getAll();
	}

	@Override
	public Patient retrievePatient(@PathVariable long id) {
		return patientService.getByID(id);
	}
	
	@Override
	public Patient retrievePatientMedicine(@PathVariable long id) {
		Patient p = patientService.getByID(id);
		p.setMedicines(medicineOperations.retrieveAllMedicines());
		return p;
	}

	@Override
	public void deletePatient(@PathVariable long id) {
		patientService.delete(id);
	}

	@Override
	public ResponseEntity<Object> createPatient(@RequestBody Patient patient) {
		Patient savedPatient = patientService.create(patient);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPatient.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@Override
	public ResponseEntity<Object> updatePatient(@RequestBody Patient patient, @PathVariable long id) {
		patientService.update(patient, id);
		return ResponseEntity.noContent().build();
	}
}