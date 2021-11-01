package it.test.rest.parents;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.test.rest.iFace.Parent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Path("papa")
public class Dad implements Parent {
	private String name;

	@Override
	@GET
	@Path("latte/{ml}")
	@Produces(MediaType.TEXT_HTML)
	public String giveMilk(@PathParam("ml") Integer ml) {
		
		Integer milk = ml*10/100;
		
		return "Non sono riuscito a dare nemmeno "+milk.toString()+" ml di latte al bambino";
	}
	
	@Override
	@GET
	@Path("pappa/{gr}")
	@Produces(MediaType.TEXT_HTML)
	public String giveBabyFood(@PathParam("gr") Integer gr) {
		
		Integer pappina = gr*10/100;
		
		return "Non sono riuscito a dare nemmeno "+pappina.toString()+" gr di pappa al bambino";
	}
	
	@Override
	@GET
	@Path("febbre")
	@Produces(MediaType.TEXT_HTML)
	public String takeBabysTemperature() {
		
		return "Il bambino si muoveva non sono riuscito a misurargli la febbre :(";
	}

}
