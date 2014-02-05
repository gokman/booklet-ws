package com.fagose.booklet.dao;

import java.util.List;

import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.to.SearchCriteria;

public interface BookDao {
		public void saveBook( Book book);
		public void deleteBook( Book book);
        public List<Book> listBook(SearchCriteria searchCriteria);
        public Book getBookById(Long bookId);
        public List<BookLike> listBookLike(SearchCriteria searchCriteria);
}


