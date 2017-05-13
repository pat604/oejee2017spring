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

import org.apache.log4j.Logger;

import hu.mitro.persistence.entity.Guitar;
import hu.mitro.persistence.entity.GuitarBrand;
import hu.mitro.persistence.entity.GuitarOwner;
import hu.mitro.persistence.parameter.GuitarParameter;
import hu.mitro.persistence.parameter.OwnerParameter;
import hu.mitro.persistence.query.GuitarQuery;
import hu.mitro.persistence.query.OwnerQuery;

@Stateless(mappedName = "/ejb/guitarService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class GuitarServiceImp implements GuitarService {

	private static final Logger LOGGER = Logger.getLogger(GuitarServiceImp.class);

	@PersistenceContext(unitName = "showyourguitar-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Guitar read(Long id) throws PersistenceException {
		LOGGER.info("Find a guitar by id.");
		Guitar guitar = null;
		try {
			guitar = this.entityManager.createNamedQuery(GuitarQuery.GET_BY_ID, Guitar.class)
					.setParameter(GuitarParameter.ID, id).getSingleResult();
		} catch (Exception e) {
			throw new PersistenceException(
					"Unknown error when fetching Guitar by id (" + id + ")!" + e.getLocalizedMessage(), e);
		}
		return guitar;
	}

	@Override
	public Guitar readBySerialNumber(String serialNumber) throws PersistenceException {
		LOGGER.info("Find a guitar by serial number.");
		Guitar guitar = null;
		try {
			guitar = this.entityManager.createNamedQuery(GuitarQuery.GET_BY_SERIALNUMBER, Guitar.class)
					.setParameter(GuitarParameter.SERIALNUMBER, serialNumber).getSingleResult();
		} catch (Exception e) {
			throw new PersistenceException("Unknown error when fetching Guitar by serialNumber (" + serialNumber + ")!"
					+ e.getLocalizedMessage(), e);
		}
		return guitar;
	}

	@Override
	public List<Guitar> readAll() throws PersistenceException {
		LOGGER.info("List all of guitars.");
		List<Guitar> guitars = this.entityManager.createNamedQuery(GuitarQuery.GET_ALL, Guitar.class).getResultList();
		return guitars;
	}

	@Override
	public void insertGuitar(String guitarBrand, String guitarType, String color, String serialNumber, Integer vintage,
			double price, String ownerName) throws PersistenceException {
		LOGGER.info("Add a guitar to the database.");
		Guitar guitar = null;
		try {
			GuitarOwner owner = this.entityManager.createNamedQuery(OwnerQuery.OWNER_BY_NAME, GuitarOwner.class)
					.setParameter(OwnerParameter.OWNERNAME, ownerName).getSingleResult();
			if (owner == null) {
				LOGGER.error("Error caused at insert of guitar, the given owner does not exist!");
				throw new PersistenceException("Error caused at insert of guitar, the given owner does not exist!");
			}
			GuitarBrand brand = GuitarBrand.valueOf(guitarBrand);
			guitar = new Guitar(brand, serialNumber, guitarType, color, vintage, price, owner);
			this.entityManager.merge(guitar);
		} catch (Exception e) {
			LOGGER.error("Unknown error caused at insert of guitar!");
			throw new PersistenceException("Unknown error caused at insert of guitar. " + e.getLocalizedMessage());
		}
		// return guitar;
	}

	@Override
	public void updateGuitarPrice(String serialNumber, double newPrice) throws PersistenceException {
		LOGGER.info("Update the price of a guitar in the database.");
		try {
			Guitar guitar = this.entityManager.createNamedQuery(GuitarQuery.GET_BY_SERIALNUMBER, Guitar.class)
					.setParameter(GuitarParameter.SERIALNUMBER, serialNumber).getSingleResult();
			if (guitar == null) {
				LOGGER.error("Error caused at update of guitar, the given serial number does not exist!");
				throw new PersistenceException(
						"Error caused at update of guitar, the given serial number does not exist!");
			}
			guitar.setGuitarPrice(newPrice);
			this.entityManager.merge(guitar);
			this.entityManager.flush();
		} catch (Exception e) {
			LOGGER.error("Unknown error caused at update of guitar!");
			throw new PersistenceException("Unknown error caused at update of guitar. " + e.getLocalizedMessage());
		}

	}

}
