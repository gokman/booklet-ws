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

import com.fagose.booklet.model.Comment;
import com.fagose.booklet.model.Hashtag;
import com.fagose.booklet.service.HashtagService;
import com.fagose.booklet.to.SearchCriteria;


@Controller
@RequestMapping("/Hashtag")
public class HashtagController{

	@Autowired
	private HashtagService hashtagService;
	
	@RequestMapping(value="/LIST/{bookId}", method = RequestMethod.GET)
	public @ResponseBody List<Hashtag> getHashtags(@PathVariable Long bookId) throws IOException {
 
		SearchCriteria searchCriteria= new SearchCriteria();
		searchCriteria.setBookId(bookId);
		List<Hashtag> hashtagList = hashtagService.listHashtags(searchCriteria);
		return hashtagList;
 
	}
	
	@RequestMapping(value = "/ADD", method = RequestMethod.POST)
	@ResponseBody
	public List<Hashtag> addHashtag(@RequestBody List<Hashtag> hashtags) {

		hashtagService.addHashtags(hashtags);
		
		return hashtags;
	}	  
	  
	@RequestMapping(value = "/delete")
	public void delete(HttpServletRequest req,@ModelAttribute("hashtag")Hashtag hashtag,BindingResult result) {
		hashtagService.deleteHashtag(hashtag);
	}	
	
}
