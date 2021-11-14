package it.infocamere.aces.commons.api.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CpkListDto {
	
	public CpkListDto(List<Cpk> cpkList) {
		super();
		this.cpkList = cpkList;
	}
	
	public CpkListDto() {
		super();
		this.cpkList = new ArrayList<Cpk>();
	}
	
	private List<Cpk> cpkList;
		
}
