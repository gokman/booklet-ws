package com.fagose.booklet.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.Action;

@Repository("actionDao")
public class ActionDaoImpl implements ActionDao {


    @Autowired
    private SessionFactory sessionFactory;

	
	@Override
	public void saveAction(Action action) {
		sessionFactory.getCurrentSession().save(action);
	}

}
