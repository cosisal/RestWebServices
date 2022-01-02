package it.infocamere.aces.commons.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.infocamere.aces.commons.api.dtos.Cpk;

public interface IAcesCpkSettingsApi {
	
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCpkList();
	
	@POST
	@Path("insert/cpk")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertCpk(Cpk cpk);
	
}
