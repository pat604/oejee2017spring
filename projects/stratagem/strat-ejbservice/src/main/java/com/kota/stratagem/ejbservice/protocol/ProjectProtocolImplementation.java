package com.kota.stratagem.ejbservice.protocol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.kota.stratagem.ejbservice.converter.ProjectConverter;
import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectStatusRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;
import com.kota.stratagem.ejbservice.util.ApplicationError;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.entity.trunk.ProjectStatus;
import com.kota.stratagem.persistence.exception.CoherentPersistenceServiceException;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.service.ProjectService;
import com.kota.stratagem.persistence.service.TaskService;

@Stateless(mappedName = "ejb/projectProtocol")
public class ProjectProtocolImplementation implements ProjectProtocol {

	private static final Logger LOGGER = Logger.getLogger(ProjectProtocolImplementation.class);

	@EJB
	private ProjectService projectService;

	@EJB
	private TaskService taskService;

	@EJB
	private ProjectConverter converter;

	@Override
	public ProjectRepresentor getProject(Long id) throws AdaptorException {
		try {
			final ProjectRepresentor representor = this.converter.to(this.projectService.read(id));
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Project (id: " + id + ") --> " + representor);
			}
			return representor;
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	//Criteria
	@Override
	public List<ProjectRepresentor> getAllProjects() {
		List<ProjectRepresentor> representors = new ArrayList<>();
		try {
			representors = this.converter.to(this.projectService.readAll());
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Fetch all projects --> " + representors.size() + " item(s)");
			}
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
		}
		return representors;
	}

	@Override
	public ProjectRepresentor saveProject(Long id, String name, ProjectStatusRepresentor status, Boolean visible) throws AdaptorException {
		try {
			Project project = null;
			final ProjectStatus projectStatus = ProjectStatus.valueOf(status.name());
			Set<Task> tasks = new HashSet<>();
			for(Task task : taskService.readAll()) {
				if(task.getProject().getId() == id)
					tasks.add(task);
			}
			if(this.projectService.exists(id)) {
				project = this.projectService.update(id, name, projectStatus, tasks, visible);
			} else {
				project = this.projectService.create(id, name, projectStatus, tasks, visible);
			}
			return this.converter.to(project);
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public void removeProject(Long id) throws AdaptorException {
		try {
			this.projectService.delete(id);
		} catch(final CoherentPersistenceServiceException e) {
			final ApplicationError error = ApplicationError.valueOf(e.getError().name());
			throw new AdaptorException(error, e.getLocalizedMessage(), e.getField());
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

}