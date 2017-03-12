package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.kota.stratagem.ejbservice.domain.TaskRepresentor;
import com.kota.stratagem.persistence.entity.Task;

@Stateless
public class TaskConverterImplementation implements TaskConverter {

	private ProjectConverterImplementation projectConverter = new ProjectConverterImplementation();
	
	@Override
	public TaskRepresentor to(Task task) { 
		return new TaskRepresentor(task.getDescription(), task.getCompletion(), this.projectConverter.to(task.getProject()));
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