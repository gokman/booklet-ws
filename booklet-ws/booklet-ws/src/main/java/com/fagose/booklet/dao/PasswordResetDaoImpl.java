package com.fagose.booklet.dao;

import java.util.ArrayList;
import java.util.List;

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
	public PasswordReset findRecordByUserId(long userId) {
		List<PasswordReset> passReset=null;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				         "SELECT * FROM PasswordReset WHERE UserID=:userId").
				         addEntity(PasswordReset.class);
		passReset=(List<PasswordReset>)query.setParameter("userId", userId).list();
		if(passReset.size()>0){
			return  passReset.get(0);
		}else{
			return null;
		}
	}

	@Override
	public PasswordReset isPasswordResetExist(long userId, long token) {
		PasswordReset passReset=new PasswordReset();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT * FROM PasswordReset WHERE UserID=:userId and ResetToken=:resetToken").
				addEntity(PasswordReset.class);
		passReset=(PasswordReset)query.setParameter("userId", userId).
				                       setParameter("resetToken", token).
				                       uniqueResult();
		return passReset;
	}
	
}