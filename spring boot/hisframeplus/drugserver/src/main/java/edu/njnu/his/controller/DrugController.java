package edu.njnu.his.controller;

import edu.njnu.his.model.Drug;
import edu.njnu.his.model.MrDr;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DrugController{
	@GetMapping("/mrdr/{mrId}")
	public List<MrDr> getMrDr(@PathVariable String mrId){
		ArrayList<MrDr> mrDrugs = new ArrayList<>();
		for(int i=0;i<5;i++){
			Double amount=Math.random()*10;
			mrDrugs.add(new MrDr(i+"",i+"10",mrId,amount.intValue(),
					new Drug(i+"10",i+"10",i+10.0,"测试药品","盒")));
		}
		return mrDrugs;
	}
}
