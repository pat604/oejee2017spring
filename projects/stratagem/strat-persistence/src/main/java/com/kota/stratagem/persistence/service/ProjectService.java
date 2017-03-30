package com.kota.stratagem.persistence.service;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.entity.trunk.ProjectStatus;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;

@Local
public interface ProjectService {

	Project create(Long id, String name, ProjectStatus status, Set<Task> tasks, Boolean visible) throws PersistenceServiceException;

	List<Project> readAll() throws PersistenceServiceException;

	Project read(Long id) throws PersistenceServiceException;
	
	List<Project> read(ProjectStatus status) throws PersistenceServiceException;

	Project update(Long id, String name, ProjectStatus status, Set<Task> tasks, Boolean visible) throws PersistenceServiceException;

	void delete(Long id) throws PersistenceServiceException;

	boolean exists(Long id) throws PersistenceServiceException;

}