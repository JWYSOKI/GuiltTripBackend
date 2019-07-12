package com.guilttrip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guilttrip.dao.TaskDao;
import com.guilttrip.entitymodel.Task;
import com.guilttrip.viewmodel.TaskViewModel;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao dao;

	@Override
	public List<Task> getTasks() {
		return dao.getTasks();
	}

	@Override
	public TaskViewModel findById(int id) {
		Task task = dao.findById(id);
		if (task == null)
			return null;
		TaskViewModel taskViewModel = new TaskViewModel(task);
		return taskViewModel;
		
		//test the if statement and the return scenarios
	}
	
	

	@Override
	public Boolean deleteTaskById(int id) {

		return dao.deleteTaskById(id);
	}

	@Override
	public Task persist(Task task) {
		return dao.persist(task);
	}

	@Override
	public Task updateTask(Task task) {
		return dao.updateTask(task);
	}
	
	@Override
	public Task convertTaskViewToEntity (TaskViewModel taskVM) {
		Task taskEntity = new Task(taskVM);
		return taskEntity;
	}

	@Override
	public TaskViewModel convertEntityToTaskViewModel(Task task) {
		TaskViewModel taskVM = new TaskViewModel(task);
		return taskVM;
	}
	
	
	

}