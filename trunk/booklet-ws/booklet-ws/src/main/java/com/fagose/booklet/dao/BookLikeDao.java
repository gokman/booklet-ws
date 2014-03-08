
package com.fagose.booklet.dao;

import java.util.List;

import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.to.SearchCriteria;

public interface BookLikeDao {
		public void saveBookLike( BookLike bookLike);
		public void deleteBookLike( BookLike bookLike);
        public List<BookLike> listBookLikes(SearchCriteria searchCriteria);
        public BookLike getBookLikeById(Long id);
}


