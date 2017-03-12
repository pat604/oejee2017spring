package com.kota.stratagem.ejbservice.protocol;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;

@Local
public interface ProjectProtocol {
	
	List<ProjectRepresentor> getAllProjects();
	
}