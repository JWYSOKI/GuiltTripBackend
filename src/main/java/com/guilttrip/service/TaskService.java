package com.guilttrip.service;

import java.util.List;

import com.guilttrip.entitymodel.Task;
import com.guilttrip.viewmodel.TaskViewModel;

public interface TaskService {

	List<Task> getTasks();

	Task updateTask(Task task);

	TaskViewModel findById(int id);

	Boolean deleteTaskById(int id);

	Task persist(Task task);
	
	Task convertTaskViewToEntity (TaskViewModel task);

	TaskViewModel convertEntityToTaskViewModel(Task task);

}


