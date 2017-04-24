package com.kota.stratagem.ejbservice.protocol;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
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
import com.kota.stratagem.persistence.util.AggregationSelector;

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
			if((id != null) && this.appUserSerive.exists(id)) {
				final Set<Objective> userObjectives = new HashSet<Objective>();
				final Set<Project> userProjects = new HashSet<Project>();
				final Set<Task> userTasks = new HashSet<Task>();
				final Set<Impediment> impedimentsReported = new HashSet<Impediment>();
				final Set<Impediment> impedimentsProcessed = new HashSet<Impediment>();
				final Set<Team> teamsSupervised = new HashSet<Team>();
				final Set<Team> memberships = new HashSet<Team>();
				for(final ObjectiveRepresentor objective : objectives) {
					userObjectives.add(this.objectiveSerive.read(objective.getId()));
				}
				for(final ProjectRepresentor project : projects) {
					userProjects.add(this.projectSerive.read(project.getId(), AggregationSelector.ELEMENTARY));
				}
				for(final TaskRepresentor task : tasks) {
					userTasks.add(this.taskService.read(task.getId()));
				}
				for(final ImpedimentRepresentor impediment : reportedImpediments) {
					impedimentsReported.add(this.impedimnetService.read(impediment.getId()));
				}
				for(final ImpedimentRepresentor impediment : processedImpediments) {
					impedimentsProcessed.add(this.impedimnetService.read(impediment.getId()));
				}
				for(final TeamRepresentor team : supervisedTeams) {
					teamsSupervised.add(this.teamService.read(team.getId()));
				}
				for(final TeamRepresentor team : teamMemberships) {
					memberships.add(this.teamService.read(team.getId()));
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

	@Override
	public String calculateHash(String passwordToHash) throws UnsupportedEncodingException, NoSuchProviderException {
		String generatedPassword = null;
		try {
			final MessageDigest md = MessageDigest.getInstance("SHA-512");
			SecureRandom.getInstance("SHA1PRNG", "SUN");

			final SecureRandom saltRandomizer = SecureRandom.getInstance("SHA1PRNG", "SUN");
			final byte[] salt = new byte[64];
			saltRandomizer.nextBytes(salt);
			final String encodedSalt = new String(salt);

			md.update(encodedSalt.getBytes("UTF-8"));
			final byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
			final StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

}
