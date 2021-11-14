package it.infocamere.aces.commons.api.response;

import it.infocamere.aces.commons.api.dtos.EsitoBaseDto;
import it.infocamere.aces.commons.api.exceptions.AcesApiException;

public class EsitoBaseResponse extends AcesApiResponse<EsitoBaseDto> {

	private static final long serialVersionUID = 1L;

	public EsitoBaseResponse() {
		super();
	}

	public EsitoBaseResponse(AcesApiException exception) {
		super(exception);
	}

	public EsitoBaseResponse(EsitoBaseDto data) {
		super(data);
	}

}