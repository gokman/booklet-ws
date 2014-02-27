package com.fagose.booklet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fagose.booklet.mail.MailSender;
import com.fagose.booklet.model.User;
import com.fagose.booklet.service.UserService;
import com.fagose.booklet.util.ApplicationUtils;


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
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody User user) {
		//kullanıcıya etkinleştirme maili gönderilecek ve enabled 0 atanacak
		//cevap gelirse enable 1 olacak
		String activationToken="";
		try {
			activationToken = MailSender.sendActivationEmail(user, 
					                          "http://localhost:8080/booklet-ws/services/user/activateUserAccount");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user.setActivationToken(activationToken);
		user.setCreationDate(new java.sql.Date(ApplicationUtils.dateFormat.getCalendar().getTime().getTime()));
		user.setLastUpdateDate(new java.sql.Date(ApplicationUtils.dateFormat.getCalendar().getTime().getTime()));
		try{
		userService.insertUser(user);
		}catch(Exception e){
			return e.toString();
		}
		return "success";
	}
	
	/*
	@RequestMapping(value="/activateUserAccount/{userName}/{activationToken}", method = RequestMethod.POST)
	@ResponseBody
	public String activateUser() {
		return "aaa";
	}*/
	

	
}
