package com.fagose.booklet.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fagose.booklet.model.PasswordReset;

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
	
}