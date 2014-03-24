package com.fagose.booklet.controller;


import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fagose.booklet.mail.MailSender;
import com.fagose.booklet.model.PasswordReset;
import com.fagose.booklet.model.User;
import com.fagose.booklet.service.PasswordResetService;
import com.fagose.booklet.service.UserService;
import com.fagose.booklet.to.SearchCriteria;
import com.fagose.booklet.util.ApplicationUtils;


@Controller
@RequestMapping("/User")
public class UserController{

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordResetService passwordResetService;
	
	@RequestMapping(value = "/LIST",method = RequestMethod.POST)
	@ResponseBody	
	public List<User> listUsers(@RequestBody SearchCriteria searchCriteria) {
		List <User> users = userService.listUsers(searchCriteria);
		
		return users;		
	}	
	
	@RequestMapping(value = "/GET_PASSWORD",method = RequestMethod.GET)
	@ResponseBody	
	public String getUserPassword(@RequestBody String email) {
		
		
		return userService.getUserPassword(email);		
	}
	
	@RequestMapping(value = "/SEND_RESET_TOKEN",method = RequestMethod.POST)
	@ResponseBody	
	public String sendPasswordResetToken(@RequestBody String email)  {
		
		BigInteger token=new BigInteger(25, new SecureRandom());
		
		User user=userService.getUserbyEmail(email);
		
		/*try {
			MailSender.sendForgottenPassword(email, token);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}*/
		PasswordReset passReset=new PasswordReset();
		passReset.setresetToken(token.longValue());
		passReset.setUserId(user.getUserId());
		passReset.setValidationDate(new java.sql.Date(ApplicationUtils.dateFormat
				.getCalendar().getTime().getTime()));
		
		passwordResetService.addPasswordReset(passReset);
		
		return "success";		
	}
	
	@RequestMapping(value = "/RESET_PASSWORD",method = RequestMethod.POST)
	@ResponseBody	
	public String resetPassword(@RequestBody String email,@RequestBody String password,@RequestBody long token) {
		//get user by email
		User user=userService.getUserbyEmail(email);
		//control password reset table with user id
		PasswordReset passReset=passwordResetService.isPasswordResetExist(user.getUserId(),token);
		
		if(passReset==null){
			return "not_found";
		}else {
			//update password from user table	
			userService.updatePassword(user.getUserId(),password);
		}
		return "success";		
	}
	
}