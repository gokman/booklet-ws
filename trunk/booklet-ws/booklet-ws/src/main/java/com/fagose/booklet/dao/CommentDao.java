package com.fagose.booklet.dao;

import java.util.List;

import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.model.Comment;
import com.fagose.booklet.to.SearchCriteria;

public interface CommentDao {
		public void saveComment( Comment comment);
		public void deleteComment( Comment comment);
		public Comment getByCommentId(Long commentId);
        public List<Comment> listComments(SearchCriteria searchCriteria);
        public List<Comment> listUserComments(SearchCriteria searchCriteria);
}


