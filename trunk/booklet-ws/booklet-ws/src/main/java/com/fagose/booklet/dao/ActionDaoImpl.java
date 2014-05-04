package com.fagose.booklet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.Action;
import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.to.SearchCriteria;
import com.fagose.booklet.util.ApplicationUtils;

@Repository("actionDao")
public class ActionDaoImpl implements ActionDao {


    @Autowired
    private SessionFactory sessionFactory;

	
	@Override
	public void saveAction(Action action) {
		sessionFactory.getCurrentSession().save(action);
	}
	@SuppressWarnings("unchecked")
	public List<Action> listAction(SearchCriteria sc) {
		Criteria crit =sessionFactory.getCurrentSession().createCriteria(Action.class);
		List<Action> resultList = null;
		
//		if(sc.getUserId()!=null){
//			crit.add(Restrictions.eq("userId", sc.getUserId()));
//		}
		crit.setMaxResults(sc.getPageSize());
		crit.setFirstResult(sc.getPageSize()*sc.getPageNumber());
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
	@Override
	public void deleteAction(Long userId, Long detailId) {
		Query q = sessionFactory.getCurrentSession().createQuery("delete from Action where userId = :userId "
				+ "and actionDetailId = :actionDetailId ");
        q.setLong("userId", userId);
        q.setLong("actionDetailId", detailId);
        q.executeUpdate();
			
		
	}
	@Override
	public Action findByUserAndActionDetailID(Long userId, Long actionDetailId) {
		return (Action)sessionFactory.
                        getCurrentSession().
                        createQuery("from Action where userId="+userId+
        		                    " and actionDetailId="+actionDetailId).
                                                            uniqueResult();
		
	}

}
