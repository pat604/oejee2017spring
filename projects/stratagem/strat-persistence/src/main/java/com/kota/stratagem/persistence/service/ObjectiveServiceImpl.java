package com.kota.stratagem.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Objective;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.parameter.ObjectiveParameter;
import com.kota.stratagem.persistence.query.AppUserQuery;
import com.kota.stratagem.persistence.query.ObjectiveQuery;

@Stateless(mappedName = "ejb/objectiveService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ObjectiveServiceImpl implements ObjectiveService {

	private static final Logger LOGGER = Logger.getLogger(ObjectiveServiceImpl.class);

	@PersistenceContext(unitName = "strat-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Objective read(Long id) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Objective by id (" + id + ")");
		}
		Objective result = null;
		try {
			result = this.entityManager.createNamedQuery(ObjectiveQuery.GET_BY_ID, Objective.class).setParameter(ObjectiveParameter.ID, id).getSingleResult();
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Objective by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Objective> readAll() throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Fetching all Objectives");
		}
		List<Objective> result = null;
		try {
			result = this.entityManager.createNamedQuery(ObjectiveQuery.GET_ALL_OBJECTIVES, Objective.class).getResultList();
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error occured while fetching AppUsers" + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
}
