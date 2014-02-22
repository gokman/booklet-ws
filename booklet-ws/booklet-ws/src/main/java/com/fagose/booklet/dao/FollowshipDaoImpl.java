package com.fagose.booklet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.Comment;
import com.fagose.booklet.model.Followship;
import com.fagose.booklet.model.User;
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
	
	public List <User> getFollowerList(Long userId){
		
		//from News as news, Users as users where news.author_id=users.id 
				
		Query q = sessionFactory.getCurrentSession().createQuery(
		"from User as us,Followship as fs where fs.followerUserId = us.userId and fs.followedUserId in (:id) ");
	    q.setLong("id", userId);
	    @SuppressWarnings("unchecked")
		List <User> userList =  (List <User>)q.list();
	        
		return userList;
		
	}
	public List <User> getFollowingList(Long userId){

		Query q = sessionFactory.getCurrentSession().createQuery(
				"from User as us,Followship as fs where fs.followedUserId = us.userId and fs.followerUserId in (:id) ");
	    q.setLong("id", userId);
	    @SuppressWarnings("unchecked")
		List <User> userList =  (List <User>)q.list();
		
	    return userList;
	}
	
	public void unFollow(Long userId,Long followedId){
		Query q = sessionFactory.getCurrentSession().createQuery("delete from Followship where followerUserId in (:id1)"
				+ "and followedUserId in (:id2) ");
        q.setLong("id1", userId);
        q.setLong("id2", followedId);
        q.executeUpdate();
		
	}

}
