package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.kota.stratagem.ejbservice.domain.TaskRepresentor;
import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Impediment;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.entity.Team;

@Stateless
public class TaskConverterImpl implements TaskConverter {

	private AppUserConverter appUserConverter = new AppUserConverterImpl();
	private TeamConverter teamConverter = new TeamConverterImpl();
	private ObjectiveConverter objectiveConverter = new ObjectiveConverterImpl();
	private ProjectConverter projectConverter = new ProjectConverterImpl();
	private ImpedimentConverter impedimentConverter = new ImpedimentConverterImpl();
	
	@Override
	public TaskRepresentor to(Task task) {
		final TaskRepresentor representor = task.getId() != null 
				? new TaskRepresentor(task.getId(), task.getName(), task.getDescription(), 
						task.getCompletion(), objectiveConverter.to(task.getObjective()), projectConverter.to(task.getProject()))
				: new TaskRepresentor(task.getName(), task.getDescription(), task.getCompletion(), 
						objectiveConverter.to(task.getObjective()), projectConverter.to(task.getProject()));
		if(task.getAssignedTeams() != null) {
			for(Team team : task.getAssignedTeams()) {
				representor.addTeam(teamConverter.to(team));
			}
		}
		if(task.getAssignedUsers() != null) {
			for(AppUser user : task.getAssignedUsers()) {
				representor.addUser(appUserConverter.to(user));
			}
		}
		if(task.getImpediments() != null) {
			for(Impediment impediment : task.getImpediments()) {
				representor.addImpediment(impedimentConverter.to(impediment));
			}
		}
		if(task.getDependantTasks() != null) {
			for(Task dependant: task.getDependantTasks()) {
				representor.addDependantTask(this.to(dependant));
			}
		}
		if(task.getTaskDependencies() != null) {
			for(Task dependencies : task.getTaskDependencies()) {
				representor.addTaskDependency(this.to(dependencies));
			}
		}
		return representor;
	}

	@Override
	public List<TaskRepresentor> to(List<Task> tasks) {
		final List<TaskRepresentor> representors = new ArrayList<>();
		for(final Task task : tasks) {
			representors.add(this.to(task));
		}
		return representors;
	}

}