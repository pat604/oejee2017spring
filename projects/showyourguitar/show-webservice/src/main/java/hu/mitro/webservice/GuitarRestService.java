package hu.mitro.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import hu.mitro.ejbservice.domain.GuitarInputStub;
import hu.mitro.ejbservice.domain.GuitarOwnerUpdateStub;
import hu.mitro.ejbservice.domain.GuitarPriceUpdateStub;
import hu.mitro.ejbservice.domain.GuitarStub;

@Path("/guitar")
public interface GuitarRestService {

	@GET
	@Path("/id/{id}")
	@Produces("application/json")
	GuitarStub getGuitar(@PathParam("id") Long id);

	@GET
	@Path("/serial/{serial}")
	@Produces("application/json")
	GuitarStub getGuitar(@PathParam("serial") String serialNumber);

	@GET
	@Path("/list")
	@Produces("application/json")
	List<GuitarStub> getAllGuitars();

	@PUT
	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
	void addGuitarStub(GuitarInputStub guitar);

	@PUT
	@Path("/modprice")
	@Consumes("application/json")
	@Produces("application/json")
	void modifyGuitarStubPrice(GuitarPriceUpdateStub guitar);

	@PUT
	@Path("/modowner")
	@Consumes("application/json")
	@Produces("application/json")
	void modifyGuitarStubOwner(GuitarOwnerUpdateStub guitar);
}
