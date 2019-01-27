package edu.njnu.his.service;

//import org.springframework.stereotype.Component;
//@Component
import edu.njnu.his.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteService{
	@Autowired
	private RestTemplate restTemplate;

	public MedicalRecord getMr(String code){
		ResponseEntity<MedicalRecord> entity = restTemplate.getForEntity("http://patient-server/mr/{1}", MedicalRecord.class, code);
		return entity.getBody();
	}
}
