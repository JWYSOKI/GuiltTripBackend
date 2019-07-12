package com.guilttrip.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guilttrip.entitymodel.Task;

@Repository
public class TaskDaoImpl implements TaskDao {

	@Autowired
	private SessionFactory factory;

	public List<Task> getTasks() {
		Criteria criteria = factory.getCurrentSession().createCriteria(Task.class);
		return (List<Task>) criteria.list();
	}

	public Task updateTask(Task task) {
		factory.getCurrentSession().update(task);
		return task;
	}

	@Override
	public Boolean deleteTaskById(int id) {
		Query query = factory.getCurrentSession().createQuery("delete from Task where id =:id");
		query.setInteger("id", id);
		int result = query.executeUpdate();
		System.out.println("Result: " + result);
		return (result>0);
	}
	
	//TODO create a test to test if this delete method fails

	@Override
	public Task findById(int id) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Task.class);
		criteria.add(Restrictions.eq("id", id));
		return (Task) criteria.uniqueResult();
	}

	@Override
	public Task persist(Task task) {
		factory.getCurrentSession().saveOrUpdate(task);
		return task;
	}

}
