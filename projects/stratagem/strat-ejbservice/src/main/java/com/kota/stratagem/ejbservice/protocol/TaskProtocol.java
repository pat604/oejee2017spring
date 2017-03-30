package com.kota.stratagem.ejbservice.protocol;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.TaskRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;

@Local
public interface TaskProtocol {

	TaskRepresentor getTask(Long id) throws AdaptorException;

	List<TaskRepresentor> getAllTasks() throws AdaptorException;

	TaskRepresentor saveTask(Long id, String description, double completion, ProjectRepresentor project) throws AdaptorException;

	void removeTask(Long id) throws AdaptorException;

}