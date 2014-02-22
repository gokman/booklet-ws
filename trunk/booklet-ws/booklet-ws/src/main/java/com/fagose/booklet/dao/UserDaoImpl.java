package com.fagose.booklet.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;

	 
	@Override
	public User getUserbyUsernamePassword(final String email,final String password) {
		
		final Session session=sessionFactory.openSession();
		final Transaction transaction=session.beginTransaction();
		
		User user=null;
		
		try{
		
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT * FROM User WHERE UserEmail=:email AND Password=:password").
				addEntity(User.class);
		user=(User)query.setParameter("email", email).
				         setParameter("password", password).
				         uniqueResult();
		}catch(Exception e){
			transaction.rollback();
		}
		session.close();
		
		return user;
	}


	@Override
	public User getUserbyEmail(final String email) {
		
		final Session session=sessionFactory.openSession();
		final Transaction transaction=session.beginTransaction();
		
		User user=null;
		
		try{
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT * FROM User WHERE UserEmail=:email").
				addEntity(User.class);
		
		user=(User)query.setParameter("email", email).uniqueResult();
		}catch(Exception e){
			transaction.rollback();
		}
		session.close();
		return user;
		
	}


	@Override
	public void insertUser(final User user) {
		
		final Session session=sessionFactory.openSession();
		final Transaction transaction=session.beginTransaction();
		
		try{
			session.save(user);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
		}
		
		session.close();
		
	}

}