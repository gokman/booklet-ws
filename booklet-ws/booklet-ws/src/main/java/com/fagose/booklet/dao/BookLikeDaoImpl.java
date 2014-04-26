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
	public void saveBookLike(BookLike bookLike) {
		sessionFactory.getCurrentSession().save(bookLike);
	}

	@SuppressWarnings("unchecked")
	public List<BookLike> listBookLikes(SearchCriteria searchriteria) {
		Criteria crit =sessionFactory.getCurrentSession().createCriteria(BookLike.class);
		List<BookLike> resultList = null;
		
		if(searchriteria.getBookId()!=null){
			crit.add(Expression.eq("bookId", searchriteria.getBookId()));
		}
		resultList = crit.list();
		
		return resultList; 
	}
	@Override
	public void deleteBookLike(BookLike comment) {
		sessionFactory.getCurrentSession().delete(comment);
	}

	@Override
	public BookLike getBookLikeById(Long id) {
		return (BookLike)sessionFactory.
				          getCurrentSession().
				          createQuery("from BookLike where bookLikeId="+id).
				          uniqueResult();
		
	}

	@Override
	public BookLike getByIdAndLikerId(Long bookId, Long likerId) {
		return (BookLike)sessionFactory.
		          getCurrentSession().
		          createQuery("from BookLike where bookId="+bookId+" and bookLikerId="+likerId).
		          uniqueResult();
	}
}