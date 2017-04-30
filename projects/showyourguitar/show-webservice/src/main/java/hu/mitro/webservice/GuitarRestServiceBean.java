package hu.mitro.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.ejbservice.exception.FacadeException;
import hu.mitro.ejbservice.facade.GuitarFacade;

@Stateless
public class GuitarRestServiceBean implements GuitarRestService {

	@EJB
	private GuitarFacade facade;

	@Override
	public GuitarStub getGuitar(Long id) {
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
		List<GuitarStub> stubs = null;
		try {
			stubs = this.facade.getGuitars();
		} catch (FacadeException e) {
			e.printStackTrace();
		}
		return stubs;
	}

}
