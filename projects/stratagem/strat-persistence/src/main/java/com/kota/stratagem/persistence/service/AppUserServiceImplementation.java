package com.kota.stratagem.persistence.service;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.trunk.Role;
import com.kota.stratagem.persistence.exception.CoherentPersistenceServiceException;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.parameter.AppUserParameter;
import com.kota.stratagem.persistence.query.AppUserQuery;
import com.kota.stratagem.persistence.util.PersistenceApplicationError;

@Stateless(mappedName = "ejb/appUserService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AppUserServiceImplementation implements AppUserService {

	private static final Logger LOGGER = Logger.getLogger(AppUserServiceImplementation.class);

	@PersistenceContext(unitName = "strat-persistence-unit")
	private EntityManager entityManager;

	@Override
	public AppUser create(String name, String passwordHash, String email, Role role, Set<Project> projects) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Create AppUser (name=" + name + ", passwordHash=" + passwordHash + ", email=" + email + ", role=" + role + ", projects=" + projects + ")");
		}
		try {
			final AppUser user = new AppUser(name, passwordHash, email, role, projects);
			this.entityManager.persist(user);
			this.entityManager.flush();
			return user;
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting user (" + name + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public AppUser read(Long id) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get AppUser by id (" + id + ")");
		}
		AppUser result = null;
		try {
			result = this.entityManager.createNamedQuery(AppUserQuery.GET_BY_ID, AppUser.class).setParameter(AppUserParameter.ID, id).getSingleResult();
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching AppUser by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<AppUser> readAll() throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Fetching all AppUsers");
		}
		List<AppUser> result = null;
		try {
			result = this.entityManager.createNamedQuery(AppUserQuery.GET_ALL_USERS, AppUser.class).getResultList();
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error occured while fetching AppUsers" + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public AppUser update(Long id, String name, String passwordHash, String email, Role role, Set<Project> projects) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Update ApUser (id: " + id + ", name=" + name + ", passwordHash=" + passwordHash + ", email=" + email + ", role=" + role + ", projects=" + projects + ")");
		}
		try {
			final AppUser user = this.read(id);
			user.setName(name);
			user.setPasswordHash(passwordHash);
			user.setEmail(email);
			user.setRole(role);
			user.setProjects(projects);
			return this.entityManager.merge(user);
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error when merging AppUser! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void delete(Long id) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove AppUser by id (" + id + ")");
		}
		if(this.exists(id)) {
			if(this.read(id).getProjects().size() == 0) {
				try {
					this.entityManager.createNamedQuery(AppUserQuery.REMOVE_BY_ID).setParameter(AppUserParameter.ID, id).executeUpdate();
				} catch(final Exception e) {
					throw new PersistenceServiceException("Unknown error when removing AppUser by id (" + id + ")! " + e.getLocalizedMessage(), e);
				}
			} else {
				throw new CoherentPersistenceServiceException(PersistenceApplicationError.HAS_DEPENDENCY, "AppUser has undeleted dependency(s)", id.toString());
			}
		} else {
			throw new CoherentPersistenceServiceException(PersistenceApplicationError.NON_EXISTANT, "AppUser doesn't exist", id.toString());
		}
	}

	@Override
	public boolean exists(Long id) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check AppUser by id (" + id + ")");
		}
		try {
			return this.entityManager.createNamedQuery(AppUserQuery.COUNT_BY_ID, Long.class).setParameter(AppUserParameter.ID, id).getSingleResult() == 1;
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting Tasks by AppUser (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

}
