import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("esempio")
public class Esempio {
	@GET
	@Path("prova")
	public String prova() {
		return "Ciao";
	}
}
