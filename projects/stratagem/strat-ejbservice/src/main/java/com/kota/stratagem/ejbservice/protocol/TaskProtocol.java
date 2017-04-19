package com.kota.stratagem.ejbservice.protocol;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.ejbservice.domain.ImpedimentRepresentor;
import com.kota.stratagem.ejbservice.domain.ObjectiveRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.TaskRepresentor;
import com.kota.stratagem.ejbservice.domain.TeamRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;

@Local
public interface TaskProtocol {

	TaskRepresentor getTask(Long id) throws AdaptorException;

	List<TaskRepresentor> getAllTasks() throws AdaptorException;

	TaskRepresentor saveTask(Long id, String name, String description, double completion, Set<TeamRepresentor> assignedTeams, Set<AppUserRepresentor> assignedUsers,
			Set<ImpedimentRepresentor> impediments, Set<TaskRepresentor> dependantTasks, Set<TaskRepresentor> taskDependencies, ObjectiveRepresentor objective, ProjectRepresentor project)
			throws AdaptorException;

	void removeTask(Long id) throws AdaptorException;

}