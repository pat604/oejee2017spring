package com.kota.stratagem.ejbservice.protocol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.kota.stratagem.ejbservice.converter.AppUserConverter;
import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.ejbservice.domain.ImpedimentRepresentor;
import com.kota.stratagem.ejbservice.domain.ObjectiveRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.RoleRepresentor;
import com.kota.stratagem.ejbservice.domain.TaskRepresentor;
import com.kota.stratagem.ejbservice.domain.TeamRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;
import com.kota.stratagem.ejbservice.util.ApplicationError;
import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Impediment;
import com.kota.stratagem.persistence.entity.Objective;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.entity.Team;
import com.kota.stratagem.persistence.entity.trunk.Role;
import com.kota.stratagem.persistence.exception.CoherentPersistenceServiceException;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.service.AppUserService;
import com.kota.stratagem.persistence.service.ImpedimentService;
import com.kota.stratagem.persistence.service.ObjectiveService;
import com.kota.stratagem.persistence.service.ProjectService;
import com.kota.stratagem.persistence.service.TaskService;
import com.kota.stratagem.persistence.service.TeamService;

@Stateless(mappedName = "ejb/appUserProtocol")
public class AppUserProtocolImpl implements AppUserProtocol {

	private static final Logger LOGGER = Logger.getLogger(AppUserProtocolImpl.class);

	@EJB
	private AppUserService appUserSerive;

	@EJB
	private ObjectiveService objectiveSerive;

	@EJB
	private ProjectService projectSerive;

	@EJB
	private TaskService taskService;

	@EJB
	private ImpedimentService impedimnetService;

	@EJB
	private TeamService teamService;

	@EJB
	private AppUserConverter converter;

	@Override
	public AppUserRepresentor getAppUser(Long id) throws AdaptorException {
		try {
			final AppUserRepresentor representor = this.converter.to(this.appUserSerive.read(id));
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get AppUser (id: " + id + ") --> " + representor);
			}
			return representor;
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<AppUserRepresentor> getAllAppUsers() throws AdaptorException {
		List<AppUserRepresentor> representors = new ArrayList<AppUserRepresentor>();
		try {
			representors = this.converter.to(this.appUserSerive.readAll());
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Fetch all AppUsers : " + representors.size() + " projects(s)");
			}
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
		}
		return representors;
	}

	@Override
	public AppUserRepresentor saveAppUser(Long id, String name, String passwordHash, String email, RoleRepresentor role, Set<ObjectiveRepresentor> objectives, Set<ProjectRepresentor> projects,
			Set<TaskRepresentor> tasks, Set<ImpedimentRepresentor> reportedImpediments, Set<ImpedimentRepresentor> processedImpediments, Set<TeamRepresentor> supervisedTeams,
			Set<TeamRepresentor> teamMemberships) throws AdaptorException {
		try {
			AppUser user = null;
			final Role userRole = Role.valueOf(role.name());
			if(id != null && this.appUserSerive.exists(id)) {
				Set<Objective> userObjectives = new HashSet<Objective>();
				Set<Project> userProjects = new HashSet<Project>();
				Set<Task> userTasks = new HashSet<Task>();
				Set<Impediment> impedimentsReported = new HashSet<Impediment>();
				Set<Impediment> impedimentsProcessed = new HashSet<Impediment>();
				Set<Team> teamsSupervised = new HashSet<Team>();
				Set<Team> memberships = new HashSet<Team>();
				for(ObjectiveRepresentor objective : objectives) {
					userObjectives.add(objectiveSerive.read(objective.getId()));
				}
				for(ProjectRepresentor project : projects) {
					userProjects.add(projectSerive.read(project.getId()));
				}
				for(TaskRepresentor task : tasks) {
					userTasks.add(taskService.read(task.getId()));
				}
				for(ImpedimentRepresentor impediment : reportedImpediments) {
					impedimentsReported.add(impedimnetService.read(impediment.getId()));
				}
				for(ImpedimentRepresentor impediment : processedImpediments) {
					impedimentsProcessed.add(impedimnetService.read(impediment.getId()));
				}
				for(TeamRepresentor team : supervisedTeams) {
					teamsSupervised.add(teamService.read(team.getId()));
				}
				for(TeamRepresentor team : teamMemberships) {
					memberships.add(teamService.read(team.getId()));
				}
				user = this.appUserSerive.update(id, name, passwordHash, email, userRole, userObjectives, userProjects, userTasks, impedimentsReported, impedimentsProcessed, teamsSupervised,
						memberships);
			} else {
				user = this.appUserSerive.create(name, passwordHash, email, userRole, null, null, null, null, null, null, null);
			}
			return this.converter.to(user);
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public void removeAppUser(Long id) throws AdaptorException {
		try {
			this.appUserSerive.delete(id);
		} catch(final CoherentPersistenceServiceException e) {
			final ApplicationError error = ApplicationError.valueOf(e.getError().name());
			throw new AdaptorException(error, e.getLocalizedMessage(), e.getField());
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

}
