package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.kota.stratagem.ejbservice.domain.TaskRepresentor;
import com.kota.stratagem.persistence.entity.Task;

@Stateless
public class TaskConverterImpl implements TaskConverter {

	@EJB
	private AppUserConverter appUserConverter;

	@EJB
	private TeamConverter teamConverter;

	@EJB
	private ObjectiveConverter objectiveConverter;

	@EJB
	private ProjectConverter projectConverter;

	@EJB
	private ImpedimentConverter impedimentConverter;

	@Override
	public TaskRepresentor to(Task task) {
		final TaskRepresentor representor = task.getId() != null
				? new TaskRepresentor(task.getId(), task.getName(), task.getDescription(), task.getCompletion(),
						task.getObjective() != null ? this.objectiveConverter.to(task.getObjective()) : null,
						task.getProject() != null ? this.projectConverter.to(task.getProject()) : null)
				: new TaskRepresentor(task.getName(), task.getDescription(), task.getCompletion(),
						task.getObjective() != null ? this.objectiveConverter.to(task.getObjective()) : null,
						task.getProject() != null ? this.projectConverter.to(task.getProject()) : null);

		// if(task.getAssignedTeams() != null) {
		// for(Team team : task.getAssignedTeams()) {
		// representor.addTeam(teamConverter.to(team));
		// }
		// }
		// if(task.getAssignedUsers() != null) {
		// for(AppUser user : task.getAssignedUsers()) {
		// representor.addUser(appUserConverter.to(user));
		// }
		// }
		// if(task.getImpediments() != null) {
		// for(Impediment impediment : task.getImpediments()) {
		// representor.addImpediment(impedimentConverter.to(impediment));
		// }
		// }
		// if(task.getDependantTasks() != null) {
		// for(Task dependant : task.getDependantTasks()) {
		// representor.addDependantTask(this.to(dependant));
		// }
		// }
		// if(task.getTaskDependencies() != null) {
		// for(Task dependencies : task.getTaskDependencies()) {
		// representor.addTaskDependency(this.to(dependencies));
		// }
		// }

		return representor;
	}

	@Override
	public List<TaskRepresentor> to(List<Task> tasks) {
		final List<TaskRepresentor> representors = new ArrayList<>();
		for (final Task task : tasks) {
			representors.add(this.to(task));
		}
		return representors;
	}

}