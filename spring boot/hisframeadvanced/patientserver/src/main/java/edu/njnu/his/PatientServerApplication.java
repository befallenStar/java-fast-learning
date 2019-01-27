package edu.njnu.his;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PatientServerApplication{
	public static void main(String[] args){
		SpringApplication.run(PatientServerApplication.class,args);
	}
}
