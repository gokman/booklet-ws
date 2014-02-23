package com.fagose.booklet.service;

import java.util.List;

import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.model.Comment;
import com.fagose.booklet.to.SearchCriteria;

public interface BookLikeService {

        public void addBookLike(BookLike bookLike);
        public void deleteBookLike(BookLike bookLike);
        public List<BookLike> listBookLikes(SearchCriteria searchCriteria);
        
}

