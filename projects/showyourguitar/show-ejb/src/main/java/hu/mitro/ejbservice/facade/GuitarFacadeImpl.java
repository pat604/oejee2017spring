package hu.mitro.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.mitro.domain.GuitarBrandStub;
import hu.mitro.domain.GuitarOwnerStub;
import hu.mitro.domain.GuitarStub;

@Stateless
public class GuitarFacadeImpl implements GuitarFacade {

	// private static final Logger LOGGER = Logger.getLogger(GuitarFacadeImpl.class);

	@Override
	public List<GuitarStub> getGuitars(GuitarOwnerStub owner) {
		// if (LOGGER.isDebugEnabled()) {
		// LOGGER.debug("Get guitars (owner: " + owner + ")");
		// }
		List<GuitarStub> guitars = new ArrayList<GuitarStub>();
		GuitarOwnerStub guitarOwner = new GuitarOwnerStub(1L, "tamas.mitro", "blacktom73@gmail.com",
				"tamas1234");
		guitars.add(new GuitarStub(1L, GuitarBrandStub.GIBSON, "Les Paul Standard", "Ebony", 1990,
				550000.0, guitarOwner));
		return guitars;
	}

	@Override
	public List<GuitarStub> getGuitars(GuitarBrandStub brand) {
		List<GuitarStub> guitars = new ArrayList<GuitarStub>();
		GuitarOwnerStub guitarOwner = new GuitarOwnerStub(1L, "tamas.mitro", "blacktom73@gmail.com",
				"tamas1234");
		guitars.add(new GuitarStub(1L, GuitarBrandStub.GIBSON, "Les Paul Standard", "Ebony", 1990,
				550000.0, guitarOwner));
		return guitars;
	}

}
