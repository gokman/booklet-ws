package com.fagose.booklet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fagose.booklet.service.UserService;


@Controller
@RequestMapping("/user")
public class LoginController{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	@ResponseBody
	public String login(ModelMap model) {
		String userEmail=SecurityContextHolder.getContext().getAuthentication().getName();
        String userName=userService.getUserbyEmail(userEmail).getUserName();
		return userEmail+":"+userName;
	}
	
}
