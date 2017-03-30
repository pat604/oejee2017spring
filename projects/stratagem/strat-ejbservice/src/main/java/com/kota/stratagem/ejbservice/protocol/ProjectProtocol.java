package com.kota.stratagem.ejbservice.protocol;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.domain.ProjectCriteria;
import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectStatusRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;

@Local
public interface ProjectProtocol {

	ProjectRepresentor getProject(Long id) throws AdaptorException;

	List<ProjectRepresentor> getAllProjects(ProjectCriteria criteria) throws AdaptorException;

	ProjectRepresentor saveProject(Long id, String name, ProjectStatusRepresentor status, Boolean visible) throws AdaptorException;

	void removeProject(Long id) throws AdaptorException;

}