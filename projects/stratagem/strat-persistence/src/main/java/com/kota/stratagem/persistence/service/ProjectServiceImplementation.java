package com.kota.stratagem.persistence.service;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.entity.trunk.ProjectStatus;
import com.kota.stratagem.persistence.exception.CoherentPersistenceServiceException;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.parameter.ProjectParameter;
import com.kota.stratagem.persistence.query.ProjectQuery;
import com.kota.stratagem.persistence.util.PersistenceApplicationError;

@Stateless(mappedName = "ejb/projectService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProjectServiceImplementation implements ProjectService {

	private static final Logger LOGGER = Logger.getLogger(ProjectServiceImplementation.class);

	@PersistenceContext(unitName = "strat-persistence-unit")
	private EntityManager entityManager;

	@EJB
	private TaskService taskService;

	@Override
	public Project create(Long id, String name, ProjectStatus status, Set<Task> tasks, Boolean visible) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Create Project (id: " + id + ", name: " + name + ", status: " + status + ", tasks: " + tasks + ", visible: " + visible + ")");
		}
		try {
			final Project project = new Project(id, name, status, tasks, visible);
			this.entityManager.persist(project);
			this.entityManager.flush();
			return project;
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Project (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Project read(Long id) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Project by id (" + id + ")");
		}
		Project result = null;
		try {
			result = this.entityManager.createNamedQuery(ProjectQuery.GET_BY_ID, Project.class).setParameter(ProjectParameter.ID, id).getSingleResult();
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Project by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Project> readAll() throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Fetching all projects");
		}
		List<Project> result = null;
		try {
			result = this.entityManager.createNamedQuery(ProjectQuery.GET_ALL_PROJECTS, Project.class).getResultList();
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error occured while fetching projects" + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Project> read(ProjectStatus status) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Projects by Status");
		}
		List<Project> result = null;
		try {
			result = this.entityManager.createNamedQuery(ProjectQuery.GET_ALL_BY_STATUS, Project.class).setParameter(ProjectParameter.STATUS, status).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Projects! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Project update(Long id, String name, ProjectStatus status, Set<Task> tasks, Boolean visible) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Update Project (id: " + id + ", name: " + name + ", status: " + status + ", tasks: " + tasks + ", visible: " + visible + ")");
		}
		try {
			final Project project = this.read(id);
			project.setName(name);
			project.setStatus(status);
			project.setTasks(tasks);
			return this.entityManager.merge(project);
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error when merging Project! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void delete(Long id) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove Project by id (" + id + ")");
		}
		if(this.exists(id)) {
			if(this.read(id).getTasks().size() > 0) {
				try {
					this.entityManager.createNamedQuery(ProjectQuery.REMOVE_BY_ID).setParameter(ProjectParameter.ID, id).executeUpdate();
				} catch(final Exception e) {
					throw new PersistenceServiceException("Unknown error when removing Project by id (" + id + ")! " + e.getLocalizedMessage(), e);
				}
			} else {
				throw new CoherentPersistenceServiceException(PersistenceApplicationError.HAS_DEPENDENCY, "Project has undeleted dependency(s)", id.toString());
			}
		} else {
			throw new CoherentPersistenceServiceException(PersistenceApplicationError.NON_EXISTANT, "Project doesn't exist", id.toString());
		}
	}

	@Override
	public boolean exists(Long id) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check Project by id (" + id + ")");
		}
		try {
			return this.entityManager.createNamedQuery(ProjectQuery.COUNT_BY_ID, Long.class).setParameter(ProjectParameter.ID, id).getSingleResult() == 1;
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting Tasks by Project (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

}