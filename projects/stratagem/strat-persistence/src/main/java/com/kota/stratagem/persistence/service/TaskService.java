package com.kota.stratagem.persistence.service;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;

@Local
public interface TaskService {

	boolean exists(Long id) throws PersistenceServiceException;

	Task create(Long id, String description, Project project, double completion) throws PersistenceServiceException;

	List<Task> readAll() throws PersistenceServiceException;

	Task read(Long id) throws PersistenceServiceException;

	Task update(Long id, String description, Project project, double completion) throws PersistenceServiceException;

	void delete(Long id) throws PersistenceServiceException;

}