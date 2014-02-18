package com.fagose.booklet.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;

	 
	@Override
	public User getUserbyUsernamePassword(final String email,final String password) {
		List<User> list = (List<User>) sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT * FROM User WHERE UserEmail=:email AND Password=:password").
				addEntity(User.class).
				setParameter("email", email).
				setParameter("password", password).
				list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}


	@Override
	public User getUserbyEmail(String email) {
		List<User> list= (List<User>) sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT * FROM User WHERE UserEmail=:email").
				addEntity(User.class).
				setParameter("email", email).
				list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}



}
