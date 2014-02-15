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
	public User getUserbyUsernamePassword(final String username,final String password) {
		List<User> a= (List<User>) sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT * FROM User WHERE UserName=:username AND Password=:password").
				addEntity(User.class).
				setParameter("username", username).
				setParameter("password", password).
				list();
		if(a.size()>0){
			return a.get(0);
		}
		return null;
	}



}
