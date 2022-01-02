package it.infocamere.aces.commons.api.response;

import java.io.Serializable;

import it.infocamere.aces.commons.api.dtos.AcesServiceListDto;
import it.infocamere.aces.commons.api.exceptions.AcesApiException;

public class AcesServiceApiResponse extends AcesApiResponse<AcesServiceListDto> implements Serializable{

	private static final long serialVersionUID = 1L;

	public AcesServiceApiResponse() {
		super();
	}

	public AcesServiceApiResponse(AcesApiException exception) {
		super(exception);
	}

	public AcesServiceApiResponse(AcesServiceListDto data) {
		super(data);
	}
	
	
}
