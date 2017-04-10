package com.kota.stratagem.persistence.service;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.trunk.Role;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;

@Local
public interface AppUserService {
	
	AppUser create(String name, String passwordHash, String email, Role role, Set<Project> projects) throws PersistenceServiceException;

	List<AppUser> readAll() throws PersistenceServiceException;

	AppUser read(Long id) throws PersistenceServiceException;

	AppUser update(Long id, String name, String passwordHash, String email, Role role, Set<Project> projects) throws PersistenceServiceException;

	void delete(Long id) throws PersistenceServiceException;

	boolean exists(Long id) throws PersistenceServiceException;
	
}
