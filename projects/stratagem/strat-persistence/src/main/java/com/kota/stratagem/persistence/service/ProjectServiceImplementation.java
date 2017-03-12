package com.kota.stratagem.persistence.service;

import java.util.List;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.query.ProjectQuery;

@Stateless(mappedName = "ejb/projectService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProjectServiceImplementation implements ProjectService {

	private static final Logger LOGGER = Logger.getLogger(ProjectServiceImplementation.class);
	
	@PersistenceContext(unitName = "strat-persistence-unit")
	private EntityManager entityManager;
	
	@EJB
	private ProjectService projectService;
	
	@Override
	public List<Project> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Fetching all projects");
		}
		List<Project> result = null;
		try {
			result = this.entityManager.createNamedQuery(ProjectQuery.GET_ALL_PROJECTS, Project.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error occured while fetching projects" + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
}