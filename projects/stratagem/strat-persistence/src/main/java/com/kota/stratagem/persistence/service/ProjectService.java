package com.kota.stratagem.persistence.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Impediment;
import com.kota.stratagem.persistence.entity.Objective;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.entity.Team;
import com.kota.stratagem.persistence.entity.trunk.ProjectStatus;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;

@Local
public interface ProjectService {

	Project create(String name, String description, ProjectStatus status, Date deadline, Boolean visible, Set<Task> tasks, Set<Team> assignedTeams, Set<AppUser> assignedUsers,
			Set<Impediment> impediments, Objective objective) throws PersistenceServiceException;

	Project read(Long id) throws PersistenceServiceException;

	List<Project> read(ProjectStatus status) throws PersistenceServiceException;

	List<Project> readAll() throws PersistenceServiceException;

	Project update(Long id, String name, String description, ProjectStatus status, Date deadline, Boolean visible, Set<Task> tasks, Set<Team> assignedTeams, Set<AppUser> assignedUsers,
			Set<Impediment> impediments, Objective objective) throws PersistenceServiceException;

	void delete(Long id) throws PersistenceServiceException;

	boolean exists(Long id) throws PersistenceServiceException;

}