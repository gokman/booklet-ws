package com.fagose.booklet.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.model.Comment;
import com.fagose.booklet.object.CustomComment;
import com.fagose.booklet.service.CommentService;
import com.fagose.booklet.to.SearchCriteria;


@Controller
@RequestMapping("/Comment")
public class CommentController{

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/LIST_COMMENTS/{bookId}", method = RequestMethod.GET)
	public @ResponseBody List<CustomComment> getBookComments(@PathVariable Long bookId) throws IOException {
 
		SearchCriteria searchCriteria= new SearchCriteria();
		searchCriteria.setBookId(bookId);
		List<CustomComment> commentList = commentService.listCustomComments(searchCriteria);
		return commentList;
 
	}
	
	@RequestMapping(value = "/ADD", method = RequestMethod.POST)
	@ResponseBody
	public Comment addComment(@RequestBody Comment comment) {

		commentService.addComment(comment);
		
		return comment;
	}	  

	@RequestMapping(value="/GET_BY_ID/{commentId}", method = RequestMethod.GET)
	public @ResponseBody Comment getCommentById(@PathVariable Long commentId) throws IOException {
 
		Comment comment= commentService.getByCommentId(commentId);
		return comment;
 
	}
	@RequestMapping(value = "/DELETE")
	@ResponseBody
	public void delete(@RequestBody Comment comment) {
		commentService.deleteComment(comment);
	}
	
	@RequestMapping(value="/LIST_USER_COMMENTS/{adderId}", method = RequestMethod.GET)
	public @ResponseBody List<Comment> getUserComments(@PathVariable Long adderId) throws IOException {
 
		SearchCriteria searchCriteria= new SearchCriteria();
		searchCriteria.setAdderId(adderId);
		List<Comment> commentList = commentService.listUserComments(searchCriteria);
		return commentList;
 
	}
	
}
