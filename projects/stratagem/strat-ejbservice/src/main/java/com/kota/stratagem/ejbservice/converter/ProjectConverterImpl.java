package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectStatusRepresentor;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;

@Stateless
public class ProjectConverterImpl implements ProjectConverter {

	private ObjectiveConverter objectiveConverter = new ObjectiveConverterImpl();
	private TaskConverter taskConverter = new TaskConverterImpl();

	@Override
	public ProjectRepresentor to(Project project) {
		final ProjectStatusRepresentor status = ProjectStatusRepresentor.valueOf(project.getStatus().toString());
		final ProjectRepresentor representor = project.getId() != null
				? new ProjectRepresentor(project.getId(), project.getName(), project.getDescription(), status, project.getDeadline(), project.getVisible(),
						objectiveConverter.to(project.getObjective()))
				: new ProjectRepresentor(project.getName(), project.getDescription(), status, project.getDeadline(), project.getVisible(), objectiveConverter.to(project.getObjective()));
		if(project.getTasks() != null) {
			for(Task task : project.getTasks()) {
				representor.addTask(taskConverter.to(task));
			}
		}

		// Teams and users!

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