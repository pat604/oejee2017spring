package hu.mitro.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import hu.mitro.persistence.entity.Guitar;
import hu.mitro.persistence.parameter.GuitarParameter;
import hu.mitro.persistence.query.GuitarQuery;

@Stateless(mappedName = "/ejb/guitarService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class GuitarServiceImp implements GuitarService {

	// private static final Logger LOGGER = Logger.getLogger(GuitarServiceImp.class);

	@PersistenceContext(unitName = "showyourguitar-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Guitar read(Long id) throws PersistenceException {

		return null;
	}

	@Override
	public Guitar read(String serialNumber) throws PersistenceException {
		Guitar guitar = null;
		try {
			guitar = this.entityManager
					.createNamedQuery(GuitarQuery.GET_BY_SERIALNUMBER, Guitar.class)
					.setParameter(GuitarParameter.SERIALNUMBER, serialNumber).getSingleResult();
		} catch (Exception e) {
			throw new PersistenceException("Unknown error when fetching Guitar by serialNumber ("
					+ serialNumber + ")!" + e.getLocalizedMessage(), e);
		}
		return guitar;
	}

	@Override
	public List<Guitar> readAll() throws PersistenceException {
		return null;
	}

}
