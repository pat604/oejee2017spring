package hu.gyigorpeter.anglerregistry.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import hu.gyigorpeter.anglerregistry.ejbservice.converter.AnglerConverter;
import hu.gyigorpeter.anglerregistry.ejbservice.exception.FacadeException;
import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Angler;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;
import hu.gyigorpeter.anglerregistry.persistence.service.AnglerService;

@Stateless
public class AnglerFacadeImpl implements AnglerFacade {

	private static final Logger LOGGER = Logger.getLogger(AnglerFacadeImpl.class.getName());

	@EJB
	private AnglerService anglerService;

	@EJB
	private AnglerConverter anglerConverter;

	@Override
	public Angler getAnglerById(long id) throws FacadeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Angler getAnglerByNationalTicket(long nationalTicketId) throws FacadeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Angler> getAllAnglers() throws FacadeException {
		List<Angler> anglerList = new ArrayList<Angler>();

		try {
			anglerList = this.anglerConverter.to(this.anglerService.readAll());

			return anglerList;
		} catch (PersistenceServiceException e) {
			LOGGER.error(e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public void delete(long id) throws FacadeException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAngler(Angler angler) throws FacadeException {
		try {
			this.anglerService.addAngler((this.anglerConverter.to(angler)));
		} catch (PersistenceServiceException e) {
			LOGGER.error(e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

}
