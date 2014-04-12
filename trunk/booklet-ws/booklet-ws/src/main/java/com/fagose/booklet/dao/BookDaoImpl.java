package com.fagose.booklet.dao;

import java.util.ArrayList;
import java.util.List;

import com.fagose.booklet.util.ApplicationUtils;
import com.fagose.booklet.util.ApplicationUtils.*;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.model.User;
import com.fagose.booklet.object.CustomBook;
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
	public long countBookByUserId(long userId){
		Criteria crit =sessionFactory.getCurrentSession().createCriteria(Book.class);
		crit.add(Expression.eq("adderId", userId));
		
		return (long)crit.list().size();
				
	}

	@Override
	public List<Book> listCommentedBooks(SearchCriteria searchCriteria) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"select b.bookId,b.name,b.description,b.adderId,b.writer,b.coverPhoto from Book as b,Comment as cm where b.bookId=cm.commentedBookId and cm.commenterId =:userId");
	    q.setLong("userId", searchCriteria.getUserId());
	    @SuppressWarnings("unchecked")
		List<Object[]> result =  q.list();
		List<Book> bookList = new ArrayList<Book>();
	    if(result!=null){
	    	for(Object[] obj : result){
	    		Book b = new Book();
	    		b.setBookId((Long)obj[0]);
	    		b.setName((String)obj[1]);
	    		b.setDescription((String)obj[2]);
	    		b.setAdderId((Long)obj[3]);
	    		b.setWriter((String)obj[4]);
	    		b.setCoverPhoto((String)obj[5]);
	    		bookList.add(b);
	    	}
	    }
	    
	    return bookList;	
	    }

	@Override
	public List<CustomBook> listCustomBook(List<Book> listBook) {
		String bookAdderIDs="";
		int counter=0;
		
		for(Book book:listBook){
			if(counter==0){
				bookAdderIDs=""+book.getAdderId();
			}else{
				bookAdderIDs=bookAdderIDs+","+book.getAdderId();
			}
			counter++;
		}
		
		Query  q=sessionFactory.getCurrentSession().createQuery("select "
				                                              + "b.bookId,b.name,b.description,b.adderId,"
				                                              + "b.writer,b.coverPhoto,u.userName "
				                                              + "from User u,Book b "
				                                              + "where u.userId=b.adderId and b.adderId in ("+bookAdderIDs+")");
		
		@SuppressWarnings("unchecked")
		List<Object[]> result=q.list();
		List<CustomBook> customBookList = new ArrayList<CustomBook>();
	    if(result!=null){
	    	for(Object[] obj : result){
	    		CustomBook b = new CustomBook();
	    		b.setBookId((Long)obj[0]);
	    		b.setName((String)obj[1]);
	    		b.setDescription((String)obj[2]);
	    		b.setAdderId((Long)obj[3]);
	    		b.setWriter((String)obj[4]);
	    		b.setCoverPhoto((String)obj[5]);
	    		b.setAdderName((String)obj[6]);
	    		customBookList.add(b);
	    	}
	    }
		return customBookList;
	}
}
