package com.fagose.booklet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.model.Comment;
import com.fagose.booklet.to.SearchCriteria;

@Repository("commentDao")
public class CommentDaoImpl implements CommentDao {


    @Autowired
    private SessionFactory sessionFactory;

	
	@Override
	public void saveComment(Comment comment) {
		sessionFactory.getCurrentSession().save(comment);
	}

	@SuppressWarnings("unchecked")
	public List<Comment> listComments(SearchCriteria searchriteria) {
		Criteria crit =sessionFactory.getCurrentSession().createCriteria(Comment.class);
		List<Comment> resultList = null;
		
		if(searchriteria.getBookId()!=null){
			crit.add(Expression.eq("commentedBookId", searchriteria.getBookId()));
		}
		resultList = crit.list();
		
		return resultList; 

	}
	@Override
	public void deleteComment(Comment comment) {
		sessionFactory.getCurrentSession().delete(comment);
	}

}
