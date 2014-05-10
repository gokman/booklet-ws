package com.fagose.booklet.service;

import java.util.List;

import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.model.Comment;
import com.fagose.booklet.object.CustomComment;
import com.fagose.booklet.to.SearchCriteria;

public interface CommentService {

        public void addComment(Comment comment);
        public void deleteComment(Comment comment);
        public Comment getByCommentId(Long commentId);
        public List<CustomComment> listCustomComments(SearchCriteria searchCriteria);
        public List<Comment> listUserComments(SearchCriteria searchCriteria);
        
}

