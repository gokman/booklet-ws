package com.fagose.booklet.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.ActionDao;
import com.fagose.booklet.dao.BookLikeDao;
import com.fagose.booklet.model.Action;
import com.fagose.booklet.model.ActionType;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.to.SearchCriteria;

@Service("bookLikeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookLikeServiceImpl implements BookLikeService {

	@Autowired
	private BookLikeDao bookLikeDao;
	
	@Autowired
	private ActionDao actionDao;

	public BookLikeServiceImpl() {
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addBookLike(BookLike bookLike) {
		bookLikeDao.saveBookLike(bookLike);
		BookLike savedBookLike=bookLikeDao.getByIdAndLikerId(bookLike.getBookId(),bookLike.getBookLikerId());
		Action action=new Action();
		action.setActionType(ActionType.ADD_BOOKLIKE.asCode());
		action.setUserId(savedBookLike.getBookLikerId());
		action.setActionDate(savedBookLike.getBookLikeDate());
		action.setActionDetailId(savedBookLike.getBookLikeId());
		actionDao.saveAction(action);
	}

	public List<BookLike> listBookLikes(SearchCriteria searchCriteria) {
		return bookLikeDao.listBookLikes(searchCriteria);
	}

	@Transactional
	public void deleteBookLike(BookLike bookLike) {
		BookLike bookLikeObject=bookLikeDao.getByIdAndLikerId(bookLike.getBookId(),bookLike.getBookLikerId());
		bookLikeDao.deleteBookLike(bookLikeObject);
		actionDao.deleteAction(bookLikeObject.getBookLikerId(), bookLikeObject.getBookLikeId());
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
