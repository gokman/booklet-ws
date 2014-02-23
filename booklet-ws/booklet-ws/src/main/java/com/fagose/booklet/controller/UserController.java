package com.fagose.booklet.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.User;
import com.fagose.booklet.service.UserService;
import com.fagose.booklet.to.SearchCriteria;


@Controller
@RequestMapping("/User")
public class UserController{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/LOGIN", method = RequestMethod.GET)
	@ResponseBody
	public String login(ModelMap model) {
		String userEmail=SecurityContextHolder.getContext().getAuthentication().getName();
        String userName=userService.getUserbyEmail(userEmail).getUserName();
		return userEmail+":"+userName;
	}
	
	@RequestMapping(value="/REGISTER", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody User user) {
		try{
		userService.insertUser(user);
		}catch(Exception e){
			return e.toString();
		}
		return "success";
	}
	@RequestMapping(value = "/LIST",method = RequestMethod.POST)
	@ResponseBody	
	public List<User> listUsers(@RequestBody SearchCriteria searchCriteria) {
		List <User> users = userService.listUsers(searchCriteria);
		
		return users;		
	}	
}
