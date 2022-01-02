package it.infocamere.aces.commons.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.infocamere.aces.commons.api.dtos.AcesServiceDto;

public interface IAcesServiceSettingsApi {
	
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	Response getAcesServiceList();
	
	@POST
	@Path("insert/service")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Response insertService(AcesServiceDto service);

}
