package com.fagose.booklet.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fagose.booklet.model.User;
import com.fagose.booklet.model.Userroles;

@Repository("userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public Userroles getUserRolebyUserId(long userId) {
		Userroles list= (Userroles) sessionFactory.getCurrentSession().createSQLQuery(
				"select * from userroles where UserID=:userId").addEntity(Userroles.class).setParameter("userId", userId).uniqueResult();
		
			return list;
	
	}

	@Override
	public void saveUserRole(User user, String role) {
		Userroles userRole=new Userroles();
		userRole.setUserId(user.getUserId());
		userRole.setRoleName(role);
		sessionFactory.getCurrentSession().save(userRole);
		
	}

}