package com.fagose.booklet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.model.Comment;
import com.fagose.booklet.to.SearchCriteria;

@Repository("bookLikeDao")
public class BookLikeDaoImpl implements BookLikeDao {


    @Autowired
    private SessionFactory sessionFactory;

	
	@Override
	public void saveBookLike(BookLike comment) {
		sessionFactory.getCurrentSession().save(comment);
	}

	@SuppressWarnings("unchecked")
	public List<BookLike> listBookLikes(SearchCriteria searchriteria) {
		Criteria crit =sessionFactory.getCurrentSession().createCriteria(Comment.class);
		List<BookLike> resultList = null;
		
		resultList = crit.list();
		
		return resultList; 
	}
	@Override
	public void deleteBookLike(BookLike comment) {
		sessionFactory.getCurrentSession().delete(comment);
	}
}
