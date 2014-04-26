package com.fagose.booklet.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.BookLikeDao;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.to.SearchCriteria;

@Service("bookLikeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookLikeServiceImpl implements BookLikeService {

	@Autowired
	private BookLikeDao bookLikeDao;

	public BookLikeServiceImpl() {
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addBookLike(BookLike bookLike) {
		bookLikeDao.saveBookLike(bookLike);
	}

	public List<BookLike> listBookLikes(SearchCriteria searchCriteria) {
		return bookLikeDao.listBookLikes(searchCriteria);
	}

	@Transactional
	public void deleteBookLike(BookLike bookLike) {
		BookLike bookLikeObject=bookLikeDao.getByIdAndLikerId(bookLike.getBookId(),bookLike.getBookLikerId());
		bookLikeDao.deleteBookLike(bookLikeObject);
	}

	@Override
	public BookLike getBookLikeById(Long id) {
		// TODO Auto-generated method stub
		return bookLikeDao.getBookLikeById(id);
	}

	@Override
	public BookLike getByIdAndLiker(Long bookId, Long bookLikerId) {
		
		return bookLikeDao.getByIdAndLikerId(bookId,bookLikerId);
	}
}
