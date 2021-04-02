package com.playzone.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.playzone.patient.service.PatientService;

@Service
public class KafkaConsumer {
	
	@Autowired
	private PatientService patientService;
		
	@KafkaListener(topics = "hospital_topic", groupId = "hospitalpatient")
	public void listenGroupFoo(String message) {
	    System.out.println("Received Message in group hospitalpatient: " + message);
	    if(message.contains(":"))
	    	patientService.deleteByHospitalId(Long.valueOf(message.split(":")[1]));
	}
}