package com.fagose.booklet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.BookDao;
import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.to.SearchCriteria;

@Service("bookService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookServiceImpl implements BookService {

        @Autowired
        private BookDao bookDao;

        public BookServiceImpl() {
        }

        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
        public void addBook(Book book) {
                bookDao.saveBook(book);
        }

        public List<Book> listBook(SearchCriteria searchCriteria) {
                return bookDao.listBook(searchCriteria);
        }
        public Book getBookById(Long bookId) {
            return bookDao.getBookById(bookId);
        }
        
        public List<BookLike> listBookLike(SearchCriteria searchCriteria) {
            return bookDao.listBookLike(searchCriteria);
        }
		@Override
		public void deleteBook(Book book) {
				bookDao.deleteBook(book);
		}
		public long countBookByUserId(Long bookId){
			return bookDao.countBookByUserId(bookId);
			 			
		}

}

