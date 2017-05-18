package hu.mitro.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import hu.mitro.ejbservice.converter.GuitarConverter;
import hu.mitro.ejbservice.domain.GuitarInputStub;
import hu.mitro.ejbservice.domain.GuitarOwnerUpdateStub;
import hu.mitro.ejbservice.domain.GuitarPriceUpdateStub;
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
		LOGGER.info("Get all of guitars (facade).");
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
		LOGGER.info("Get a guitar by serial number (facade).");
		GuitarStub guitar = null;
		try {
			guitar = this.guitarConverter.to(this.guitarService.readBySerialNumber(serial));
		} catch (PersistenceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return guitar;
	}

	@Override
	public void addGuitar(GuitarInputStub guitar) throws FacadeException {
		LOGGER.info("Add a guitar to the application (facade).");
		try {
			this.guitarService.insertGuitar(guitar.getGuitarBrand(), guitar.getGuitarType(), guitar.getColor(),
					guitar.getSerialNumber(), guitar.getVintage(), guitar.getPrice(), guitar.getOwner());
		} catch (PersistenceException e) {
			LOGGER.info("Unknown error caused at insert process.");
			throw new FacadeException("Unknown error caused at add process. " + e.getLocalizedMessage());
		}
	}

	@Override
	public void updateGuitarPrice(GuitarPriceUpdateStub guitar) throws FacadeException {
		LOGGER.info("Change the price of a guitar (facade).");
		try {
			this.guitarService.updateGuitarPrice(guitar.getSerialNumber(), guitar.getNewPrice());
		} catch (Exception e) {
			LOGGER.info("Unknown error caused at update process.");
			throw new FacadeException("Unknown error caused at update process. " + e.getLocalizedMessage());
		}
	}

	@Override
	public void updateGuitarOwner(GuitarOwnerUpdateStub guitar) throws FacadeException {
		LOGGER.info("Change the owner of a guitar (facade).");
		try {
			this.guitarService.updateGuitarOwner(guitar.getSerialNumber(), guitar.getNewOwnerName());
		} catch (Exception e) {
			LOGGER.info("Unknown error caused at update process.");
			throw new FacadeException("Unknown error caused at update process. " + e.getLocalizedMessage());
		}
	}

}
