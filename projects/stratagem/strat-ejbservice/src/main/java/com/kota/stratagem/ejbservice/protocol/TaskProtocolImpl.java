package com.kota.stratagem.ejbservice.protocol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.kota.stratagem.ejbservice.converter.TaskConverter;
import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.ejbservice.domain.ImpedimentRepresentor;
import com.kota.stratagem.ejbservice.domain.ObjectiveRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.TaskRepresentor;
import com.kota.stratagem.ejbservice.domain.TeamRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;
import com.kota.stratagem.ejbservice.util.ApplicationError;
import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Impediment;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.entity.Team;
import com.kota.stratagem.persistence.exception.CoherentPersistenceServiceException;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.service.AppUserService;
import com.kota.stratagem.persistence.service.ImpedimentService;
import com.kota.stratagem.persistence.service.ObjectiveService;
import com.kota.stratagem.persistence.service.ProjectService;
import com.kota.stratagem.persistence.service.TaskService;
import com.kota.stratagem.persistence.service.TeamService;

@Stateless(mappedName = "ejb/taskProtocol")
public class TaskProtocolImpl implements TaskProtocol {

	private static final Logger LOGGER = Logger.getLogger(TaskProtocolImpl.class);

	@EJB
	private ObjectiveService objectiveService;

	@EJB
	private ProjectService projectSerivce;

	@EJB
	private TaskService taskService;

	@EJB
	private TeamService teamService;

	@EJB
	private AppUserService appUserService;

	@EJB
	private ImpedimentService impedimentService;

	@EJB
	private TaskConverter converter;

	@Override
	public TaskRepresentor getTask(Long id) throws AdaptorException {
		try {
			final TaskRepresentor representor = this.converter.to(this.taskService.read(id));
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Task (id: " + id + ") --> " + representor);
			}
			return representor;
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<TaskRepresentor> getAllTasks() {
		List<TaskRepresentor> representors = new ArrayList<>();
		try {
			representors = this.converter.to(this.taskService.readAll());
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Fetch all tasks --> " + representors.size() + " item(s)");
			}
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
		}
		return representors;
	}

	@Override
	public TaskRepresentor saveTask(Long id, String name, String description, double completion, Set<TeamRepresentor> assignedTeams, Set<AppUserRepresentor> assignedUsers,
			Set<ImpedimentRepresentor> impediments, Set<TaskRepresentor> dependantTasks, Set<TaskRepresentor> taskDependencies, ObjectiveRepresentor objective, ProjectRepresentor project)
			throws AdaptorException {
		try {
			Task task = null;
			if(this.taskService.exists(id)) {
				Set<Team> teams = new HashSet<Team>();
				Set<AppUser> users = new HashSet<AppUser>();
				Set<Impediment> taskImpediments = new HashSet<Impediment>();
				Set<Task> dependants = new HashSet<Task>();
				Set<Task> dependencies = new HashSet<Task>();
				for(TeamRepresentor team : assignedTeams) {
					teams.add(teamService.read(team.getId()));
				}
				for(AppUserRepresentor user : assignedUsers) {
					users.add(appUserService.read(user.getId()));
				}
				for(ImpedimentRepresentor impediment : impediments) {
					taskImpediments.add(impedimentService.read(impediment.getId()));
				}
				for(TaskRepresentor taskRepresentor : dependantTasks) {
					dependants.add(taskService.read(taskRepresentor.getId()));
				}
				for(TaskRepresentor taskRepresentor : taskDependencies) {
					dependants.add(taskService.read(taskRepresentor.getId()));
				}
				task = this.taskService.update(id, name, description, completion, teams, users, taskImpediments, dependants, dependencies, objectiveService.read(objective.getId()),
						projectSerivce.read(project.getId()));
			} else {
				task = this.taskService.create(name, description, completion, null, null, null, null, null, objectiveService.read(objective.getId()), projectSerivce.read(project.getId()));
			}
			return this.converter.to(task);
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public void removeTask(Long id) throws AdaptorException {
		try {
			this.taskService.delete(id);
		} catch(final CoherentPersistenceServiceException e) {
			final ApplicationError error = ApplicationError.valueOf(e.getError().name());
			throw new AdaptorException(error, e.getLocalizedMessage(), e.getField());
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

}