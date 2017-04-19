package com.kota.stratagem.ejbservice.protocol;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.ejbservice.domain.ImpedimentRepresentor;
import com.kota.stratagem.ejbservice.domain.ObjectiveRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectCriteria;
import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectStatusRepresentor;
import com.kota.stratagem.ejbservice.domain.TaskRepresentor;
import com.kota.stratagem.ejbservice.domain.TeamRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;

@Local
public interface ProjectProtocol {

	ProjectRepresentor getProject(Long id) throws AdaptorException;

	List<ProjectRepresentor> getAllProjects(ProjectCriteria criteria) throws AdaptorException;

	ProjectRepresentor saveProject(Long id, String name, String description, ProjectStatusRepresentor status, Date deadline, Boolean visible, Set<TaskRepresentor> tasks,
			Set<TeamRepresentor> assignedTeams, Set<AppUserRepresentor> assignedUsers, Set<ImpedimentRepresentor> impediments, ObjectiveRepresentor objective) throws AdaptorException;

	void removeProject(Long id) throws AdaptorException;

}