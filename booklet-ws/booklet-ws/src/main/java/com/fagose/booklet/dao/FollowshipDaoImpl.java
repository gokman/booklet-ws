package com.fagose.booklet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.Comment;
import com.fagose.booklet.model.Followship;
import com.fagose.booklet.to.SearchCriteria;

@Repository("followshipDao")
public class FollowshipDaoImpl implements FollowshipDao {


    @Autowired
    private SessionFactory sessionFactory;

	
	@Override
	public void saveFollowship(Followship followship) {
		sessionFactory.getCurrentSession().save(followship);
	}
	public Followship getByFollowshipId(Long followshipId){
		Criteria crit =sessionFactory.getCurrentSession().createCriteria(Followship.class);
		List<Followship> resultList = null;
		Followship result =null;
		crit.add(Expression.eq("followshipId", followshipId));

		resultList = crit.list();
		
		if(resultList !=null && resultList.size()>0){
			result = resultList.get(0);
		}
		return result;
		
	}
	@Override
	public void deleteFollowship(Followship followship) {
		sessionFactory.getCurrentSession().delete(followship);
	}

}
