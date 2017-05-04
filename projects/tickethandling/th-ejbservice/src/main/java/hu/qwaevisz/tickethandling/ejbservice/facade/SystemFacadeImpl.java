
package hu.qwaevisz.tickethandling.ejbservice.facade;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.qwaevisz.tickethandling.ejbservice.converter.CustomerConverter;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.ejbserviceclient.domain.SystemStub;
import hu.qwaevisz.tickethandling.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.tickethandling.persistence.service.CustomerService;

@PermitAll
@Stateless(mappedName = "ejb/systemFacade")
public class SystemFacadeImpl implements SystemFacade {

	private static final Logger LOGGER = Logger.getLogger(SystemFacadeImpl.class);

	@EJB
	private CustomerService custService;

	@EJB
	private CustomerConverter custConverter;

	@Override
	public SystemStub getSystem(String id) throws FacadeException {
		try {
			final SystemStub stub = this.custConverter.to(this.custService.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get System by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<SystemStub> getSystems() throws FacadeException {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Systems");
			}
			List<SystemStub> stubs = this.custConverter.to(this.custService.readAll());
			return stubs;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<String> getSysLabels() throws FacadeException {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get System labels");
			}
			List<String> labels = this.custService.readSysLabels();
			return labels;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

}
