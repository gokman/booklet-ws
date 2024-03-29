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
import com.fagose.booklet.object.CustomResetPassword;
import com.fagose.booklet.service.PasswordResetService;
import com.fagose.booklet.service.UserService;
import com.fagose.booklet.to.SearchCriteria;
import com.fagose.booklet.util.ApplicationUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


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
		String localEmail=ApplicationUtils.getJsonValue(email, "email");
		User user=userService.getUserbyEmail(localEmail);
		
		//isleme baslamadan once passwordreset tablosunda kayit kaldi ise onu sil
		PasswordReset passReset=passwordResetService.findRecordByUserId(user.getUserId());
		if(passReset!=null){
		    passwordResetService.deletePasswordReset(passReset);
		}
		
		try {
			MailSender.sendForgottenPassword(email, token);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		PasswordReset passReset2=new PasswordReset();
		passReset2.setresetToken(token.longValue());
		passReset2.setUserId(user.getUserId());
		passReset2.setValidationDate(new java.sql.Date(ApplicationUtils.dateFormat
				.getCalendar().getTime().getTime()));
		
		passwordResetService.addPasswordReset(passReset2);
		
		return "success";		
	}
	
	@RequestMapping(value = "/RESET_PASSWORD",method = RequestMethod.POST)
	@ResponseBody	
	public String resetPassword(@RequestBody CustomResetPassword object) {
		//get user by email
		User user=userService.getUserbyEmail(object.getEmail());
		//control password reset table with user id
		PasswordReset passReset=passwordResetService.isPasswordResetExist(user.getUserId(),
				object.getToken());
		
		if(passReset==null){
			return "not_found";
		}else {
			//update password from user table	
			userService.updatePassword(user.getUserId(),object.getPassword());
		}
		return "success";		
	}
	
	@RequestMapping(value = "/IS_USER_EXIST",method = RequestMethod.POST)
	@ResponseBody	
	public boolean isUserExist(@RequestBody User user) {
		//get user by email
		User userLocal=userService.getUserbyEmail(user.getUserEmail());
		//control password reset table with user id
		if(userLocal==null){
			return false;
		}else{
			return true;
		}
	}
	@RequestMapping(value = "/UPDATE", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody User user) {

		try {
			userService.updateUser(user);
		} catch (Exception e) {
			return e.toString();
		}
		return "success";
	}	
	
}