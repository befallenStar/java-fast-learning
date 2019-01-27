package edu.njnu.his.service;

import edu.njnu.his.model.MedicalRecord;
import edu.njnu.his.model.MrDr;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component	//@Service
public class DrugFallbackService implements DrugService{
	@Override
	public List<MrDr> getMrDrug(String mrId){
		ArrayList<MrDr> mrDrugs = new ArrayList<>();
		mrDrugs.add(new MrDr("error","error","error",null,null));
		return mrDrugs;
	}
}
