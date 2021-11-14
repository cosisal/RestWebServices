package it.infocamere.aces.commons.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface IAcesCpkSettingsApi {
	
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCpkList();
	
}
