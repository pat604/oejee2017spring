package hu.mitro.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.mitro.ejbservice.domain.GuitarInputStub;
import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.ejbservice.exception.FacadeException;
import hu.mitro.ejbservice.facade.GuitarFacade;

@Stateless
public class GuitarRestServiceBean implements GuitarRestService {

	private static final Logger LOGGER = Logger.getLogger(GuitarRestServiceBean.class);

	@EJB
	private GuitarFacade facade;

	@Override
	public GuitarStub getGuitar(Long id) {
		LOGGER.info("Get guitar by id (" + id + ")");
		GuitarStub stub = null;
		try {
			stub = this.facade.getGuitar(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stub;
	}

	@Override
	public GuitarStub getGuitar(String serialNumber) {
		LOGGER.info("Get guitar by serial number (" + serialNumber + ")");
		GuitarStub stub = null;
		try {
			stub = this.facade.getGuitar(serialNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stub;
	}

	@Override
	public List<GuitarStub> getAllGuitars() {
		LOGGER.info("Get all guitars");
		List<GuitarStub> stubs = null;
		try {
			stubs = this.facade.getGuitars();
		} catch (FacadeException e) {
			e.printStackTrace();
		}
		return stubs;
	}

	@Override
	public void addGuitarStub(GuitarInputStub guitar) {
		LOGGER.info("Add a new guitar.");
		try {
			this.facade.addGuitar(guitar);
		} catch (FacadeException e) {
			e.printStackTrace();
		}
		// return stub;
	}

}
