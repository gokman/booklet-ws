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
	
	@RequestMapping(value = "/LIST",method = RequestMethod.POST)
	@ResponseBody	
	public List<User> listUsers(@RequestBody SearchCriteria searchCriteria) {
		List <User> users = userService.listUsers(searchCriteria);
		
		return users;		
	}	
}
