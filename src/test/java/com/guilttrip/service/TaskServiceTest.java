package com.guilttrip.service;

import java.util.ArrayList;
import java.util.List;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guilttrip.dao.TaskDao;
import com.guilttrip.entitymodel.Task;

public class TaskServiceTest {

	@Mock
	private TaskDao testDao;

	@InjectMocks
	private TaskServiceImpl service;

	@BeforeClass
	public void Setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deleteTaskByIdTest() {
		Mockito.when(testDao.deleteTaskById(Mockito.anyInt())).thenReturn(true);
		System.out.println(service.deleteTaskById(0));
		Assert.assertTrue(service.deleteTaskById(0));
	}
	
	
	@Test
	public void deletByIdTest_ReturnsFalse() {
		Mockito.when(testDao.deleteTaskById(Mockito.anyInt())).thenReturn(false);
		Assert.assertFalse((service.deleteTaskById(0)));
	}
	
	@Test
	public void findByIdTest_ReturnsNull() {
		Mockito.when(testDao.findById(Mockito.anyInt())).thenReturn(null);
		Assert.assertNull(service.findById(0));	
	}
	

	@Test
	public void findByIdTest() {
		Task task = new Task();

		int id = 0;
		task.setId(id);
		Mockito.when(testDao.findById(id)).thenReturn(task);
		Assert.assertEquals(service.findById(id), task);
	}

	@Test
	public void persistTest() {
		Task task = new Task();
		Mockito.when(testDao.persist(task)).thenReturn(task);
		Assert.assertEquals(task, service.persist(task));

	}

	@Test
	public void getTasksTest() {
		List<Task> tasks = new ArrayList<Task>();
		Mockito.when(testDao.getTasks()).thenReturn(tasks);
		Assert.assertEquals(service.getTasks(), tasks);
	}

	@Test
	public void updateTaskTest() {

		Task task = new Task();
		Mockito.when(testDao.updateTask(ArgumentMatchers.any(Task.class))).thenReturn(task);

		Assert.assertEquals(service.updateTask(task), task);
	}

	@Test
	public void updateTaskTest_Negative() {

		Task task = null;
		Mockito.when(testDao.updateTask(ArgumentMatchers.any(Task.class))).thenReturn(task);

		Assert.assertEquals(service.updateTask(task), task);
	}

}
