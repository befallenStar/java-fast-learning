package edu.njnu.his.service;

import edu.njnu.his.model.MedicalRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="patient-server")	//feignclient的name属性指向具体的某一个微服务，name和微服务spring.application.name相同
public interface PatientService{
	@RequestMapping("/mr/{code}")
	public MedicalRecord getMr(@PathVariable("code") String code);
}
