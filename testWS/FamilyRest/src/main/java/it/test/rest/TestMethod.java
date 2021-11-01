package it.test.rest;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("test")
public class TestMethod {
	
	@GET
	@Path("pappa")
	@Produces(MediaType.TEXT_HTML)
	public String pappa() {
		return "Pappa";
	}
	
	@GET
    @Path("download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFileWithGet(@QueryParam("file") String file) {
        System.out.println("Download file "+file);
        File fileDownload = new File("/home/salvo/Scaricati/" + file);
        ResponseBuilder response = Response.ok((Object) fileDownload);
        response.header("Content-Disposition", "attachment;filename=" + file);
        return response.build();
    }
}
