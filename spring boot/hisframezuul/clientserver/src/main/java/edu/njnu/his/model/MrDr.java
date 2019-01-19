package edu.njnu.his.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MrDr{
	private String id;
	private String drId;
	private String mrID;
	private Integer amount;
	private Drug drug;
}
