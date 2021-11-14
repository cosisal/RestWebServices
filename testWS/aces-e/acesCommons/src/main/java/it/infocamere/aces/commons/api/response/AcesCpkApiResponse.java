package it.infocamere.aces.commons.api.response;

import java.io.Serializable;

import it.infocamere.aces.commons.api.dtos.CpkListDto;
import it.infocamere.aces.commons.api.exceptions.AcesApiException;

public class AcesCpkApiResponse extends AcesApiResponse<CpkListDto> implements Serializable{

	private static final long serialVersionUID = 1L;

	public AcesCpkApiResponse() {
		super();
	}

	public AcesCpkApiResponse(AcesApiException exception) {
		super(exception);
	}

	public AcesCpkApiResponse(CpkListDto data) {
		super(data);
	}
	
	
}
