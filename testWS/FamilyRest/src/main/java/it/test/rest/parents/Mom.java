package it.test.rest.parents;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.test.rest.iFace.Parent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Path("mamma")
public class Mom implements Parent {
	private String name;

	@Override
	@GET
	@Path("latte/{ml}/{dolce}")
	@Produces(MediaType.TEXT_HTML)
	public String giveMilk(@PathParam("ml") Integer ml, @PathParam("dolce") Boolean dolce) {
		return "Ho dato " + ml.toString() + " ml di latte al bambino";
	}

	@Override
	@GET
	@Path("pappa/{gr}")
	@Produces(MediaType.TEXT_HTML)
	public String giveBabyFood(@PathParam("gr") Integer gr) {
		return "Ho dato " + gr.toString() + " gr di pappa al bambino!";
	}

	@Override
	@GET
	@Path("febbre")
	@Produces(MediaType.TEXT_HTML)
	public String takeBabysTemperature() {

		Double soglia = new Double(6);
		Double febbreMisurata = 36 + soglia * Math.random();

		return "Temperatura del bambino: " + Math.round(febbreMisurata * 100.0) / 100.0;
	}

	@POST
	@Path("carezza")
	public String carezza() {
		return "Ho dato una carezza al bambino";
	}

}
