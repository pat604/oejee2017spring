package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import hu.gyigorpeter.anglerregistry.persistence.entity.AnglerEntity;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;
import hu.gyigorpeter.anglerregistry.persistence.query.AnglerQuery;

@Stateless
@Transactional
public class AnglerServiceImpl implements AnglerService {

	@PersistenceContext(unitName = "ar-persistence-unit")
	private EntityManager entityManager;

	private static final Logger LOGGER = Logger.getLogger(AnglerServiceImpl.class.getName());

	@Override
	public AnglerEntity readById(long id) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnglerEntity readByNationalTicketId(long id) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnglerEntity> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Querying all angler entries from DB...");
		}

		try {
			return this.entityManager.createNamedQuery(AnglerQuery.GET_ALL, AnglerEntity.class).getResultList();
		} catch (Exception e) {
			LOGGER.error(e);
			throw new PersistenceServiceException("Error when reading all anglers from DB..." + e.getLocalizedMessage(), e);
		}

	}

}
