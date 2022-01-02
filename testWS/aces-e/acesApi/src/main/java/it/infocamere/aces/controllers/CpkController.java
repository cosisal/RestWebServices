package it.infocamere.aces.controllers;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.infocamere.aces.acese.ejb.dao.impl.AcesCpkDaoEJB;
import it.infocamere.aces.acese.ejb.dao.local.AcesCpkDaoLocal;
import it.infocamere.aces.acese.ejb.exceptions.EjbLookupException;
import it.infocamere.aces.acese.ejb.utils.EJBLookup;
import it.infocamere.aces.commons.api.dtos.Cpk;
import it.infocamere.aces.commons.api.dtos.CpkListDto;
import it.infocamere.aces.commons.api.dtos.EsitoBaseDto;
import it.infocamere.aces.commons.api.exceptions.AcesApiException;
import it.infocamere.aces.commons.api.response.AcesCpkApiResponse;
import it.infocamere.aces.commons.api.response.EsitoBaseResponse;
import it.infocamere.aces.commons.api.rest.IAcesCpkSettingsApi;

@Path("cpk")
public class CpkController implements IAcesCpkSettingsApi{

//	@GetMapping(value = "/hello")
//	public ModelAndView hello(@RequestParam(required = false, defaultValue = "World") String name) {
//		ModelAndView ret = new ModelAndView("home");
//		if (name.equals("World")) {
//			ret = new ModelAndView("test");
//		}
//		// Adds an objet to be used in home.jsp
//		ret.addObject("name", name);
//		return ret;
//	}
	
	@GET
	@Path("testList")
	@Produces(MediaType.TEXT_HTML)
	public String getList() {
		return "Lista";
	}
	
	@Override
	public Response getCpkList(){
		
		CpkListDto cpkList = new CpkListDto();
		
		try {
			cpkList = getRicercaEjb().getCpkList();
		} catch (EjbLookupException e) {
			return new EsitoBaseResponse(new AcesApiException(e)).toResponse();
		}
		
		return new AcesCpkApiResponse(cpkList).toResponse();
	}
	
	@Override
	public Response insertCpk(Cpk cpk) {
		
		try {
			getRicercaEjb().insertCpk(cpk);
		} catch (EjbLookupException e) {
			return new EsitoBaseResponse(new AcesApiException(e)).toResponse();
		}
		
		return new EsitoBaseResponse(new EsitoBaseDto(Boolean.TRUE)).toResponse();
	}
	
	// Lookup EJB
	private AcesCpkDaoLocal getRicercaEjb () throws EjbLookupException {
			return (AcesCpkDaoLocal) EJBLookup.lookupLocal(AcesCpkDaoEJB.class);
		}
	
}
