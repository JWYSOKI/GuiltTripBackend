package com.guilttrip.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guilttrip.entitymodel.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		Criteria criteria = factory.getCurrentSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	@Override
	public User updateUser(User user) {
		factory.getCurrentSession().update(user);
		return user;
	}

	@Override
	public int deleteUserById(int id) {
		Query deleteQuery = factory.getCurrentSession().createQuery("delete from User where id =:id");
		deleteQuery.setInteger("id", id);
		return deleteQuery.executeUpdate();
		
	}

	//HQL requirement
	@Override
	public User findById(int id) {
		String hqlString = "from User where id=:id";
		Query findQuery = factory.getCurrentSession().createQuery(hqlString);
		findQuery.setInteger("id", id);

		return (User) findQuery.uniqueResult();

	}

	@Override
	public User persist(User user) {
		factory.getCurrentSession().save(user);
		return user;
	}

}
