package com.fagose.booklet.dao;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.PasswordReset;
import com.fagose.booklet.model.User;

@Repository("passwordResetDao")
public class PasswordResetDaoImpl implements PasswordResetDao {


    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void savePasswordReset(PasswordReset passReset) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(passReset);
	}

	@Override
	public void deletePasswordReset(PasswordReset passReset) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(passReset);
	}

	@Override
	public PasswordReset isPasswordResetService(long userId,long resetToken) {
		PasswordReset passReset=new PasswordReset();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT * FROM PasswordReset WHERE userId=:userId AND resetToken=:resetToken").
				addEntity(PasswordReset.class);
		passReset=(PasswordReset)query.setParameter("userId", userId).
				         setParameter("resetToken", resetToken).
				         uniqueResult();
		return passReset;
	}
	
}