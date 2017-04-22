package hu.mitro.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import hu.mitro.ejbservice.converter.GuitarConverter;
import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.ejbservice.exception.FacadeException;
import hu.mitro.persistence.entity.Guitar;
import hu.mitro.persistence.service.GuitarService;

@Stateless
public class GuitarFacadeImpl implements GuitarFacade {

	private static final Logger LOGGER = Logger.getLogger(GuitarFacadeImpl.class);

	@EJB
	private GuitarService guitarService;
	@EJB
	private GuitarConverter guitarConverter;

	@Override
	public GuitarStub getGuitar(Long guitarId) throws FacadeException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Guitar (id: " + guitarId + ")");
		}
		GuitarStub guitar = null;
		try {
			guitar = this.guitarConverter.to(this.guitarService.read(guitarId));
		} catch (PersistenceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return guitar;
	}

	@Override
	public List<GuitarStub> getGuitars() throws FacadeException {
		List<GuitarStub> guitarStubs = new ArrayList<GuitarStub>();
		try {
			List<Guitar> guitars = this.guitarService.readAll();
			for (Guitar g : guitars) {
				guitarStubs.add(this.guitarConverter.to(g));
			}
		} catch (PersistenceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return guitarStubs;
	}

	@Override
	public GuitarStub getGuitar(String serial) throws FacadeException {
		GuitarStub guitar = null;
		try {
			guitar = this.guitarConverter.to(this.guitarService.readBySerialNumber(serial));
		} catch (PersistenceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return guitar;
	}

}
