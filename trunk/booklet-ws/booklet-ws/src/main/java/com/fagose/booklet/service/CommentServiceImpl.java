package com.fagose.booklet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.CommentDao;
import com.fagose.booklet.dao.UserDao;
import com.fagose.booklet.model.Comment;
import com.fagose.booklet.model.User;
import com.fagose.booklet.object.CustomComment;
import com.fagose.booklet.to.SearchCriteria;

@Service("commentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private UserDao userDao;

	public CommentServiceImpl() {
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addComment(Comment comment) {
		commentDao.saveComment(comment);
	}

	public List<CustomComment> listCustomComments(SearchCriteria searchCriteria) {
		List<Comment> comments=commentDao.listComments(searchCriteria);
		List<CustomComment> customComments=new ArrayList<CustomComment>();
		User user=new User();
		for(Comment comment:comments){
			user=userDao.getUserbyUserId(comment.getCommenterId());
			customComments.add(new CustomComment(comment, user.getUserName()));
		}
		return customComments;
	}

	@Override
	public void deleteComment(Comment comment) {
		commentDao.deleteComment(comment);
	}
	public Comment getByCommentId(Long commentId){
		Comment comment = commentDao.getByCommentId(commentId);
		return comment;
	}

	@Override
	public List<Comment> listUserComments(SearchCriteria searchCriteria) {
		
		return commentDao.listUserComments(searchCriteria);
	}
}
