package com.kota.stratagem.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.persistence.entity.Project;

@Local
public interface ProjectConverter {
	
	ProjectRepresentor to(Project project);
	
	List<ProjectRepresentor> to(List<Project> projects);
	
}