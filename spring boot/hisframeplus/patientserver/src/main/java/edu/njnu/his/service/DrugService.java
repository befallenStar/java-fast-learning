package edu.njnu.his.service;

import edu.njnu.his.model.MrDr;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "drug-server",fallback = DrugFallbackService.class)
public interface DrugService{
	@RequestMapping("/mrdr/{mrId}")
	List<MrDr> getMrDrug(@PathVariable String mrId);
}
