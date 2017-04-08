package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectStatusRepresentor;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;

@Stateless
public class ProjectConverterImplementation implements ProjectConverter {

	private TaskConverterImplementation taskConverter = new TaskConverterImplementation();

	@Override
	public ProjectRepresentor to(Project project) {
		final ProjectStatusRepresentor status = ProjectStatusRepresentor.valueOf(project.getStatus().toString());
		final ProjectRepresentor representor = new ProjectRepresentor(project.getId(), project.getName(), project.getDescription(), status, project.getVisible());
		for(Task task : project.getTasks()) {
			representor.addTask(taskConverter.to(task));
		}
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