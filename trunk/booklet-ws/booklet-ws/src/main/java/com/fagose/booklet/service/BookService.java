package com.fagose.booklet.service;

import java.util.List;

import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.to.SearchCriteria;

public interface BookService {

        public void addBook(Book book);
        public void deleteBook(Book book);
        public List<Book> listBook(SearchCriteria bookSearchCriteria);
        public Book getBookById(Long bookId);
        public List<BookLike> listBookLike(SearchCriteria searchCriteria);
        public long countBookByUserId(Long bookId);
}

