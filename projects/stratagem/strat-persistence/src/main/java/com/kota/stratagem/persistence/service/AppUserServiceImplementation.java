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
import com.kota.stratagem.persistence.exception.PersistenceServiceException;

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
			LOGGER.debug("Create AppUser (name=" + name + ", passwordHash=" + passwordHash + ", email=" + email+ ", role=" + role + ", projects=" + projects + ")");
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
	public List<AppUser> readAll() throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser read(Long id) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser update(Long id, String name, String passwordHash, String email, Role role, Set<Project> projects)
			throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long id) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
