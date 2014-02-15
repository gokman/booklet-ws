package com.fagose.booklet.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.Userroles;

@Repository("userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {


    @Autowired
    private SessionFactory sessionFactory;

	
	@Override
	public Userroles getUserRolebyUserId(long userId) {
		List<Userroles> list= sessionFactory.getCurrentSession().createSQLQuery(
				"select * from userroles where UserID="+userId).addEntity(Userroles.class).list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}



}
