package hu.mitro.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import hu.mitro.ejbservice.converter.GuitarConverter;
import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.persistence.entity.Guitar;
import hu.mitro.persistence.service.GuitarService;

@Stateless
public class GuitarFacadeImpl implements GuitarFacade {

	// private static final Logger LOGGER = Logger.getLogger(GuitarFacadeImpl.class);

	@EJB
	private GuitarService guitarService;
	@EJB
	private GuitarConverter guitarConverter;

	@Override
	public GuitarStub getGuitar(Long guitarId) {
		GuitarStub guitar = null;
		try {
			guitar = this.guitarConverter.to(this.guitarService.read(guitarId));
		} catch (Exception e) {
			throw new PersistenceException(e.getLocalizedMessage());
		}
		return guitar;
	}

	@Override
	public List<GuitarStub> getGuitars() {
		List<GuitarStub> guitarStubs = new ArrayList<GuitarStub>();
		List<Guitar> guitars = this.guitarService.readAll();
		for (Guitar g : guitars) {
			guitarStubs.add(this.guitarConverter.to(g));
		}
		return guitarStubs;
	}

	@Override
	public GuitarStub getGuitar(String serial) {
		GuitarStub guitar = null;
		try {
			guitar = this.guitarConverter.to(this.guitarService.readBySerialNumber(serial));
		} catch (Exception e) {
			throw new PersistenceException(e.getLocalizedMessage());
		}
		return guitar;
	}

}
