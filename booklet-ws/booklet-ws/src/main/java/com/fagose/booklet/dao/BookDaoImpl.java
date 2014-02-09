package com.fagose.booklet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.to.SearchCriteria;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {


    @Autowired
    private SessionFactory sessionFactory;

	
	@Override
	public void saveBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> listBook(SearchCriteria sc) {
		Criteria crit =sessionFactory.getCurrentSession().createCriteria(Book.class);
		List<Book> resultList = null;
		
		if(sc.getAdderId()!=null){
			crit.add(Expression.eq("adderId", sc.getAdderId()));
		}
		if(sc.getBookId()!=null){
			crit.add(Expression.eq("bookId", sc.getBookId()));
		}else if(sc.getBookIdList()!=null &&sc.getBookIdList().size()>0){
			crit.add(Expression.in("bookId", sc.getBookIdList()));
		}
		if(sc.getName()!=null){
			crit.add(Expression.eq("name", sc.getName()));
		}
		if(sc.getWriter()!=null){
			crit.add(Expression.eq("writer", sc.getWriter()));
		}
		resultList = crit.list();
		
		return resultList; 

	}
	@SuppressWarnings("unchecked")
	public Book getBookById(Long bookId) {
		Criteria crit =sessionFactory.getCurrentSession().createCriteria(Book.class);
		List<Book> resultList = null;
		Book result =null;
		crit.add(Expression.eq("bookId", bookId));

		resultList = crit.list();
		
		if(resultList !=null && resultList.size()>0){
			result = resultList.get(0);
		}
		
		return result; 

	}	
	@SuppressWarnings("unchecked")
	public List<BookLike> listBookLike(SearchCriteria searchriteria) {
		Criteria crit =sessionFactory.getCurrentSession().createCriteria(BookLike.class);
		List<BookLike> resultList = null;
		
		if(searchriteria.getAdderId()!=null){
			crit.add(Expression.eq("bookLikerId", searchriteria.getAdderId()));
		}
		if(searchriteria.getBookId()!=null){
			crit.add(Expression.eq("bookId", searchriteria.getBookId()));
		}
		resultList = crit.list();
		
		return resultList; 

	}
	@Override
	public void deleteBook(Book book) {
		sessionFactory.getCurrentSession().delete(book);
	}

}
