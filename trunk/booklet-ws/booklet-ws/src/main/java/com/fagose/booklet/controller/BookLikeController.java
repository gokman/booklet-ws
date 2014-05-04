package com.fagose.booklet.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fagose.booklet.model.Action;
import com.fagose.booklet.model.ActionType;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.service.ActionService;
import com.fagose.booklet.service.BookLikeService;
import com.fagose.booklet.to.SearchCriteria;


@Controller
@RequestMapping("/BookLike")
public class BookLikeController{

	@Autowired
	private BookLikeService bookLikeService;
	
	@Autowired
	private ActionService actionService;
	
	@RequestMapping(value = "/ADD", method = RequestMethod.POST)
	@ResponseBody
	public BookLike addBookLike(@RequestBody BookLike bookLike) {
		
		bookLikeService.addBookLike(bookLike);
		return bookLike;
	}	  
	@RequestMapping(value = "/LIST",method = RequestMethod.POST)
	@ResponseBody	
	public List<BookLike> listBookLikes(@RequestBody SearchCriteria searchCriteria) {
		List <BookLike> bookLikes = bookLikeService.listBookLikes(searchCriteria);
		
		return bookLikes;		
	}
	
	@RequestMapping(value = "/DELETE", method = RequestMethod.POST)
	@ResponseBody
	public String deleteBookLike(@RequestBody BookLike bookLike) {
		bookLikeService.deleteBookLike(bookLike);
		return "";
	}
}