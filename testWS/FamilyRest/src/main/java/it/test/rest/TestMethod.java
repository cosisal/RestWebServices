package it.test.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class TestMethod {
	
	@GET
	@Path("pappa")
	@Produces(MediaType.TEXT_HTML)
	public String pappa() {
		return "Pappa";
	}
	
}
