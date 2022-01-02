package it.infocamere.aces.commons.api.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AcesServiceListDto {
	
	public AcesServiceListDto(List<AcesServiceDto> acesServiceList) {
		super();
		this.acesServiceList = acesServiceList;
	}
	
	public AcesServiceListDto() {
		super();
		this.acesServiceList = new ArrayList<AcesServiceDto>();
	}
	
	private List<AcesServiceDto> acesServiceList;
		
}
