package com.playzone.patient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.playzone.patient.entity.Patient;
import com.playzone.patient.exception.PatientNotFoundException;
import com.playzone.patient.repository.PatientRepository;
import com.playzone.patient.search.SpecificationBuilder;

@Service
public class PatientServiceImpl implements PatientService{
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> getAll() {
		return patientRepository.findAll();
	}

	@Override
	public Patient getByID(Long id) {
		Optional<Patient> Patient = patientRepository.findById(id);
		if (!Patient.isPresent())
			throw new PatientNotFoundException(HttpStatus.NOT_FOUND.name(),"id-" + id);
		return Patient.get();
	}

	@Override
	public Patient create(Patient p) {
		return patientRepository.save(p);
	}

	@Override
	public void update(Patient p, Long id) {
		getByID(id);//check exists
		p.setId(id);		
		patientRepository.save(p);		
	}

	@Override
	public void delete(Long id) {
		patientRepository.deleteById(id);		
	}

	@Override
	public List<Patient> search(String query) {
		SpecificationBuilder builder = new SpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(query + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
       
        Specification<Patient> spec = builder.build();
        List<Patient> patients = new ArrayList<Patient>();
        patients.addAll(patientRepository.findAll(spec));
        log.debug("query:{}, count:{}", query, patients.size());		
        return patients;
	}

	@Override
	public void deleteByHospitalId(Long id) {
		String queryByHospitalId = "query=hospitalId:"+id;
		List<Patient> patients = search(queryByHospitalId);
		patientRepository.deleteAll(patients);		
	}	

}
