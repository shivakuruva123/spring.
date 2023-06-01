package org.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	EntityManager manager;
	public User saveUser(User user) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(user);
		transaction.begin();
		transaction.commit();
		return user;
	}
	public User updateUser(User user) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(user);
		transaction.begin();
		transaction.commit();
		return user;
	}
	public boolean deleteUser(int id) {
		EntityTransaction transaction = manager.getTransaction();
		User u = manager.find(User.class, id);
		if(u!=null) {
			manager.remove(u);
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}
	public User verifyUser(long phone, String password) {
		String hql = "select u from User u where u.phone=?1 and u.password=?2";
		Query query = manager.createQuery(hql);
		query.setParameter(1, phone);
		query.setParameter(2, password);
		try {
			return(User)query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}
