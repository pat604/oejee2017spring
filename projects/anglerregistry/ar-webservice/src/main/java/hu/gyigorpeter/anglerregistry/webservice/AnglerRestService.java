package hu.gyigorpeter.anglerregistry.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Angler;

@Path("/angler")
public interface AnglerRestService {

	@GET
	@Path("/list")
	@Produces("application/json")
	List<Angler> getAngler();

}
