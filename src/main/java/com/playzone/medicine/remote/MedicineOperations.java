package com.playzone.medicine.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playzone.medicine.dto.Medicine;

@FeignClient(name="medicine-service")
@RequestMapping("/medicine")
public interface MedicineOperations {

	@GetMapping("")
	public List<Medicine> retrieveAllMedicines();

}
