package com.fagose.booklet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.CommentDao;
import com.fagose.booklet.model.Comment;
import com.fagose.booklet.to.SearchCriteria;

@Service("commentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	public CommentServiceImpl() {
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addComment(Comment comment) {
		commentDao.saveComment(comment);
	}

	public List<Comment> listComments(SearchCriteria searchCriteria) {
		return commentDao.listComments(searchCriteria);
	}

	@Override
	public void deleteComment(Comment comment) {
		commentDao.deleteComment(comment);
	}
	public Comment getByCommentId(Long commentId){
		Comment comment = commentDao.getByCommentId(commentId);
		return comment;
	}
}
