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
import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.RoleRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;
import com.kota.stratagem.ejbservice.util.ApplicationError;
import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.trunk.Role;
import com.kota.stratagem.persistence.exception.CoherentPersistenceServiceException;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.service.AppUserService;
import com.kota.stratagem.persistence.service.ProjectService;

@Stateless(mappedName = "ejb/appUserProtocol")
public class AppUserProtocolImplementation implements AppUserProtocol {

	private static final Logger LOGGER = Logger.getLogger(AppUserProtocolImplementation.class);

	@EJB
	private AppUserService appUserSerive;

	@EJB
	private ProjectService projectSerive;

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
			List<AppUser> users = null;
			users = this.appUserSerive.readAll();
			representors = this.converter.to(users);
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Fetch all AppUsers : " + representors.size() + " projects(s)");
			}
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
		}
		return representors;
	}

	@Override
	public AppUserRepresentor saveAppUser(Long id, String name, String passwordHash, String email, RoleRepresentor role, Set<ProjectRepresentor> projects) throws AdaptorException {
		try {
			AppUser user = null;
			final Role userRole = Role.valueOf(role.name());
			if(id != null && this.appUserSerive.exists(id)) {
				Set<Project> userProjects = new HashSet<Project>();
				for(ProjectRepresentor project : projects) {
					userProjects.add(projectSerive.read(project.getId()));
				}
				user = this.appUserSerive.update(id, name, passwordHash, email, userRole, userProjects);
			} else {
				user = this.appUserSerive.create(name, passwordHash, email, userRole, null);
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
