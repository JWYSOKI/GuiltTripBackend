package com.guilttrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilttrip.entitymodel.Task;
import com.guilttrip.service.TaskService;
import com.guilttrip.viewmodel.TaskViewModel;

@RestController
@RequestMapping("task")
public class TaskRestController {

	@Autowired
	private TaskService service;

	@GetMapping()
	public ResponseEntity<List<Task>> getAllTasks() {
		List<Task> allTasks = service.getTasks();
		ResponseEntity<List<Task>> allTasksResponse = new ResponseEntity<>(allTasks, HttpStatus.OK);
		return allTasksResponse;
	}

	@GetMapping("{id}")
	public ResponseEntity<TaskViewModel> getTaskById(@PathVariable int id) {
		TaskViewModel taskViewModel = service.findById(id);
		return new ResponseEntity<>(taskViewModel, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<TaskViewModel> createTask(@RequestBody TaskViewModel task) {
		Task taskEntity = service.convertTaskViewToEntity(task);
		Task persistedTask = service.persist(taskEntity);
		TaskViewModel persistedTaskAsVm = service.convertEntityToTaskViewModel(persistedTask);
		return new ResponseEntity<>(persistedTaskAsVm, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<TaskViewModel> updateTask(@PathVariable("id") int id, @RequestBody TaskViewModel task) {
		Task taskEntity = service.convertTaskViewToEntity(task);
		Task updatedTaskEntity = service.updateTask(taskEntity);
		TaskViewModel updatedTaskAsVm = service.convertEntityToTaskViewModel(updatedTaskEntity);
		return new ResponseEntity<>(updatedTaskAsVm, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteTaskById(@PathVariable int id) {
		Boolean deleteTask = service.deleteTaskById(id);
		return new ResponseEntity<>(deleteTask, HttpStatus.OK);
	}
}
