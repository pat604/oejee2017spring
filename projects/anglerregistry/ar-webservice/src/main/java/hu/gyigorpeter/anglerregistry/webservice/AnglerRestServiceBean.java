package hu.gyigorpeter.anglerregistry.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.gyigorpeter.anglerregistry.ejbservice.facade.AnglerFacade;
import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Angler;

@Stateless
public class AnglerRestServiceBean implements AnglerRestService {

	private final static Logger LOGGER = Logger.getLogger(AnglerRestServiceBean.class.getName());

	@EJB
	AnglerFacade anglerFacade;

	@Override
	public List<Angler> getAngler() {
		// TODO Auto-generated method stub

		try {

			LOGGER.info("REST API: try to get all anglers");

			return this.anglerFacade.getAllAnglers();
		} catch (Exception e) {
			return new ArrayList<Angler>();
		}
	}

}
