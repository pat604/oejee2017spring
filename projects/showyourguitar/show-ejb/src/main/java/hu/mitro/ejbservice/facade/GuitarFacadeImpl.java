package hu.mitro.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.mitro.ejbservice.converter.GuitarConverter;
import hu.mitro.ejbservice.domain.GuitarBrandStub;
import hu.mitro.ejbservice.domain.GuitarOwnerStub;
import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.persistence.service.GuitarService;

@Stateless
public class GuitarFacadeImpl implements GuitarFacade {

	// private static final Logger LOGGER = Logger.getLogger(GuitarFacadeImpl.class);

	@EJB
	private GuitarService guitarService;
	@EJB
	private GuitarConverter guitarConverter;

	@Override
	public List<GuitarStub> getGuitars(GuitarOwnerStub owner) {
		// if (LOGGER.isDebugEnabled()) {
		// LOGGER.debug("Get guitars (owner: " + owner + ")");
		// }

		List<GuitarStub> guitars = new ArrayList<GuitarStub>();
		// GuitarOwnerStub guitarOwner = new GuitarOwnerStub("tamas.mitro", "blacktom73@gmail.com",
		// "tamas1234");
		// guitars.add(new GuitarStub(GuitarBrandStub.GIBSON, "Les Paul Standard", "Ebony", 1990,
		// 550000.0, guitarOwner));
		// try {
		// guitars.add(this.guitarService.)
		// } catch (Exception e) {
		// }
		return guitars;
	}

	@Override
	public List<GuitarStub> getGuitars(GuitarBrandStub brand) {
		List<GuitarStub> guitars = new ArrayList<GuitarStub>();
		GuitarOwnerStub guitarOwner = new GuitarOwnerStub("tamas.mitro", "blacktom73@gmail.com", "tamas1234");
		guitars.add(new GuitarStub(GuitarBrandStub.GIBSON, "Les Paul Standard", "Ebony", 1990, 550000.0, guitarOwner));
		return guitars;
		// return null;
	}

	@Override
	public GuitarStub getGuitar(Long guitarId) {
		GuitarStub guitar = this.guitarConverter.to(this.guitarService.read(guitarId));
		return guitar;
	}

}
