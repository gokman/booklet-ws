package com.fagose.booklet.dao;

import static com.fagose.booklet.util.ApplicationConstants.EMPTY_STRING;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.User;
import com.fagose.booklet.to.SearchCriteria;
import com.fagose.booklet.util.ApplicationUtils;

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
	@SuppressWarnings("unchecked")
	public List<User> listUsers(SearchCriteria sc) {
		Criteria crit =sessionFactory.getCurrentSession().createCriteria(User.class);
		List<User> resultList = null;
		
		
		if(sc.getUserName()!=null && !sc.getUserName().equals(EMPTY_STRING)){
			crit.add(Restrictions.like("nameName", sc.getUserName()));
		}
		if(sc.getPageSize()!= 0){
			crit.setMaxResults(sc.getPageSize());
			crit.setFirstResult(sc.getPageSize()*sc.getPageNumber());
		}
		if(sc.getOrderByCrit()!=null){
			if(sc.getOrderByDrc()!=null && sc.getOrderByDrc().equals(ApplicationUtils.ORDER_BY_DIRECTION_DESCENDING)){
				crit.addOrder(Order.desc(sc.getOrderByCrit()));	
			}else{
				crit.addOrder(Order.asc(sc.getOrderByCrit()));
			}
		}
		resultList = crit.list();
		
		return resultList; 

	}

}