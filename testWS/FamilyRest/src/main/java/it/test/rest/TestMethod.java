package it.test.rest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
		System.out.println("Download file " + file);
		File fileDownload = new File("/home/salvo/Scaricati/" + file);
		ResponseBuilder response = Response.ok((Object) fileDownload);
		response.header("Content-Disposition", "attachment;filename=" + file);
		return response.build();
	}

	@GET
<<<<<<< HEAD
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> listFiles() {
		List<String> listFiles = new ArrayList<>();
//        File fileFolder = new File(Config.UPLOAD_FOLDER);
		File fileFolder = new File("/home/salvo/Scaricati/");
		File[] list = fileFolder.listFiles();
		for (File f : list) {
			if (!f.isDirectory()) {
				listFiles.add(f.getName());
			}
		}
		return listFiles;
	}

	@POST
	@Path("/download")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	@Consumes("application/x-www-form-urlencoded")
	public Response downloadFileWithPost(@FormParam("file") String file) {
		String path = System.getProperty("user.home") + File.separator + "uploads";
		path = "/home/salvo/Scaricati/";
		File fileDownload = new File(path + File.separator + file);
		ResponseBuilder response = Response.ok((Object) fileDownload);
		response.header("Content-Disposition", "attachment;filename=" + file);
		return response.build();
	}

=======
    @Path("download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFileWithGet(@QueryParam("file") String file) {
        System.out.println("Download file "+file);
        File fileDownload = new File("/home/salvo/Scaricati/" + file);
        ResponseBuilder response = Response.ok((Object) fileDownload);
        response.header("Content-Disposition", "attachment;filename=" + file);
        return response.build();
    }
	
	@GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> listFiles() {
        List<String> listFiles = new ArrayList<>();
//        File fileFolder = new File(Config.UPLOAD_FOLDER);
        File fileFolder = new File("/home/salvo/Scaricati/");
        File[] list = fileFolder.listFiles();
        for (File f: list) {
            if (!f.isDirectory()) {
                listFiles.add(f.getName());
            }
        }
        return listFiles;
    }
>>>>>>> main
}
