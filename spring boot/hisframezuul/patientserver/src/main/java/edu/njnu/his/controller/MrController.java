package edu.njnu.his.controller;

import edu.njnu.his.dao.MrDao;
import edu.njnu.his.model.MedicalRecord;
import edu.njnu.his.model.MrDr;
import edu.njnu.his.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MrController{
	@Autowired
	private Environment environment;    //代表当前patientserver服务的运行环境，所以可以通过它读取配置文件内容

	@Autowired
	private MrDao mrDao;

	@Autowired
	private DrugService drugService;

	@GetMapping("/mr/{code}")
	public MedicalRecord findMr(@PathVariable String code){
		//.getProperty可以通过传入配置文件中的某一个属性名称来获取对应属性值
		System.out.println("from port:" + environment.getProperty("server.port"));
		MedicalRecord mr = mrDao.findByCode(code);
		if(mr != null && mr.getCode() != null && ! "".equals(mr.getCode())){
			List<MrDr> mrDrugs = drugService.getMrDrug(mr.getCode());
			mr.setMrDrugs(mrDrugs);
		}
		return mr;
	}
}
