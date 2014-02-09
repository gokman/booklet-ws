package com.fagose.booklet.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.Hashtag;
import com.fagose.booklet.to.SearchCriteria;

@Repository("hashtagDao")
public class HashtagDaoImpl implements HashtagDao {


    @Autowired
    private SessionFactory sessionFactory;

	
	@Override
	public void saveHashtags(List<Hashtag> hashtags) {
		
		Session session = sessionFactory.getCurrentSession();
		for (Hashtag hashtag : hashtags) {
			session.save(hashtag);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Hashtag> listHashtags(SearchCriteria searchriteria) {
		Criteria crit =sessionFactory.getCurrentSession().createCriteria(Hashtag.class);
		List<Hashtag> resultList = null;
		
		if(searchriteria.getBookId()!=null){
			crit.add(Expression.eq("bookId", searchriteria.getBookId()));
		}
		if(searchriteria.getTag()!=null){
			crit.add(Expression.like("tag", searchriteria.getTag(),MatchMode.ANYWHERE));
		}
		
		resultList = crit.list();
		
		return resultList; 

	}
	@Override
	public void deleteHashtag(Hashtag hashtag) {
		sessionFactory.getCurrentSession().delete(hashtag);
	}

}
