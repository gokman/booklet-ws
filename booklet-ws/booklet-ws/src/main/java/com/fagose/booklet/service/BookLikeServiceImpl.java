package com.fagose.booklet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.BookLikeDao;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.to.SearchCriteria;

@Service("commentService")
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

	@Override
	public void deleteBookLike(BookLike bookLike) {
		bookLikeDao.deleteBookLike(bookLike);
	}
}
