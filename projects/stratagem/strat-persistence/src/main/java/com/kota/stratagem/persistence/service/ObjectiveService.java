package com.kota.stratagem.persistence.service;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Objective;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.entity.Team;
import com.kota.stratagem.persistence.entity.trunk.ObjectiveStatus;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;

@Local
public interface ObjectiveService {

	Objective create(String name, String description, int priority, ObjectiveStatus status, Set<Project> projects, Set<Task> tasks, Set<Team> assignedTeams,
			Set<AppUser> assignedUsers) throws PersistenceServiceException;

	Objective read(Long id) throws PersistenceServiceException;

	List<Objective> readAll() throws PersistenceServiceException;

	Objective update(Long id, String name, String description, int priority, ObjectiveStatus status, Set<Project> projects, Set<Task> tasks,
			Set<Team> assignedTeams, Set<AppUser> assignedUsers) throws PersistenceServiceException;

	void delete(Long id) throws PersistenceServiceException;

	boolean exists(Long id) throws PersistenceServiceException;

}
