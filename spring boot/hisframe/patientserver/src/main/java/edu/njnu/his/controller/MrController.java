package edu.njnu.his.controller;

import edu.njnu.his.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MrController{
	@Autowired
	private Environment environment;	//代表当前patientserver服务的运行环境，所以可以通过它读取配置文件内容
	@GetMapping("/mr/{id}")
	public MedicalRecord findMr(@PathVariable String id){
		//.getProperty可以通过传入配置文件中的某一个属性名称来获取对应属性值
		System.out.println("from port:"+environment.getProperty("server.port"));
		return new MedicalRecord(id,"1314","姜乃松","男",18);
	}
}
