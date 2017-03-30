package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectStatusRepresentor;
import com.kota.stratagem.persistence.entity.Project;

@Stateless
public class ProjectConverterImplementation implements ProjectConverter {

	@Override
	public ProjectRepresentor to(Project project) {
		final ProjectStatusRepresentor status = ProjectStatusRepresentor.valueOf(project.getStatus().toString());
		final ProjectRepresentor representor = new ProjectRepresentor(project.getId(), project.getName(), status, project.getVisible());
		return representor;
	}

	@Override
	public List<ProjectRepresentor> to(List<Project> projects) {
		final List<ProjectRepresentor> representors = new ArrayList<>();
		for(final Project project : projects) {
			representors.add(this.to(project));
		}
		return representors;
	}

}