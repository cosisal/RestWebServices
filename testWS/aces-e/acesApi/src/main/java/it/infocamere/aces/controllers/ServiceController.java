package it.infocamere.aces.controllers;


import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import it.infocamere.aces.acese.ejb.dao.impl.AcesServiceDaoEJB;
import it.infocamere.aces.acese.ejb.dao.local.AcesServiceDaoLocal;
import it.infocamere.aces.acese.ejb.exceptions.EjbLookupException;
import it.infocamere.aces.acese.ejb.utils.EJBLookup;
import it.infocamere.aces.commons.api.dtos.AcesServiceDto;
import it.infocamere.aces.commons.api.dtos.AcesServiceListDto;
import it.infocamere.aces.commons.api.dtos.EsitoBaseDto;
import it.infocamere.aces.commons.api.exceptions.AcesApiException;
import it.infocamere.aces.commons.api.response.AcesServiceApiResponse;
import it.infocamere.aces.commons.api.response.EsitoBaseResponse;
import it.infocamere.aces.commons.api.rest.IAcesServiceSettingsApi;

@Path("service")
public class ServiceController implements IAcesServiceSettingsApi{	
	
	@Override
	public Response getAcesServiceList(){
		
		AcesServiceListDto serviceList = new AcesServiceListDto();
		
		try {
			serviceList = getRicercaEjb().getAcesServiceList();
		} catch (EjbLookupException e) {
			return new EsitoBaseResponse(new AcesApiException(e)).toResponse();
		}
		
		return new AcesServiceApiResponse(serviceList).toResponse();
	}
	
	@Override
	public Response insertService(AcesServiceDto service) {
		
		try {
			getRicercaEjb().insertAcesService(service);
		} catch (EjbLookupException e) {
			return new EsitoBaseResponse(new AcesApiException(e)).toResponse();
		}
		
		return new EsitoBaseResponse(new EsitoBaseDto(Boolean.TRUE)).toResponse();
	}
	
	// Lookup EJB
	private AcesServiceDaoLocal getRicercaEjb () throws EjbLookupException {
			return (AcesServiceDaoLocal) EJBLookup.lookupLocal(AcesServiceDaoEJB.class);
		}
	
}
