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
import com.fagose.booklet.model.Followship;
import com.fagose.booklet.model.User;
import com.fagose.booklet.service.FollowshipService;
import com.fagose.booklet.to.SearchCriteria;


@Controller
@RequestMapping("/Followship")
public class FollowshipController{

	@Autowired
	private FollowshipService followshipService;
	
	@RequestMapping(value = "/ADD", method = RequestMethod.POST)
	@ResponseBody
	public Followship addFollowship(@RequestBody Followship followship) {
		followshipService.addFollowship(followship);
		return followship;
	}	  

	@RequestMapping(value="/GET_BY_ID/{followshipId}", method = RequestMethod.GET)
	public @ResponseBody Followship getFollowshipById(@PathVariable Long followshipId) throws IOException {
		Followship followship= followshipService.getFollowshipById(followshipId);
		return followship;
	}

	@RequestMapping(value = "/delete")
	public void delete(HttpServletRequest req,@ModelAttribute("followship")Followship followship ,BindingResult result) {
		followshipService.deleteFollowship(followship);
	}	
	
	@RequestMapping(value="/GET_FOLLOWER_LIST/{userId}", method = RequestMethod.GET)
	public @ResponseBody List <User> getFollowerList(@PathVariable Long userId) throws IOException {
		List <User> followerUserList= followshipService.getFollowerList(userId);
		return followerUserList;
	}
	
	@RequestMapping(value="/GET_FOLLOWING_LIST/{userId}", method = RequestMethod.GET)
	public @ResponseBody List <User> getFollowingList(@PathVariable Long userId) throws IOException {
		List <User> followingUserList= followshipService.getFollowingList(userId);
		return followingUserList;
	}
	@RequestMapping(value="/UNFOLLOW/{userId}/{followedId}", method = RequestMethod.DELETE)
	public void unfollow(@PathVariable Long userId,@PathVariable Long followedId) throws IOException {
		followshipService.unFollow(userId, followedId);
	}
	
	@RequestMapping(value = "/LIST_FOLLOWSHIPS",method = RequestMethod.POST)
	@ResponseBody	
	public List<Followship> listFollowships(@RequestBody SearchCriteria searchCriteria) {
		List <Followship> followships = followshipService.listFollowship(searchCriteria);
		
		return followships;		
	}	
}
