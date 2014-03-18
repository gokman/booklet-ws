
package com.fagose.booklet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fagose.booklet.mail.MailSender;
import com.fagose.booklet.model.User;
import com.fagose.booklet.service.UserService;
import com.fagose.booklet.util.ApplicationConstants;
import com.fagose.booklet.util.ApplicationUtils;

@Controller
@RequestMapping("/User")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/LOGIN", method = RequestMethod.GET)
	@ResponseBody
	public String login(ModelMap model) {
		String userEmail = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		User user = userService.getUserbyEmail(userEmail);
		return userEmail + ":" + user.getUserName()+":"+user.getUserId();
	}

	@RequestMapping(value = "/REGISTER", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody User user) {
		// kullanıcıya etkinleştirme maili gönderilecek ve enabled 0 atanacak
		// cevap gelirse enable 1 olacak
		String activationToken = "";
		try {
			activationToken = MailSender.sendActivationEmail(user,
					"http://localhost:8080/booklet-ws/services/User/activateUserAccount/"
							+ user.getUserName());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user.setActivationToken(activationToken);
		user.setCreationDate(new java.sql.Date(ApplicationUtils.dateFormat
				.getCalendar().getTime().getTime()));
		user.setLastUpdateDate(new java.sql.Date(ApplicationUtils.dateFormat
				.getCalendar().getTime().getTime()));
		try {
			userService.insertUser(user);
		} catch (Exception e) {
			return e.toString();
		}
		return "success";
	}
	

	@RequestMapping(value = "/activateUserAccount/{userName}/{activationToken}")
	@ResponseBody
	public String activateUser(@PathVariable("userName") String username,
			@PathVariable("activationToken") String activationToken) {
		// find user
		User user=userService.getUserbyUserName(username);
		// add record to role table
		userService.saveUserRole(user, ApplicationConstants.ROLE_USER);
		// activate user
		userService.activateUser(user);
		
		return ApplicationConstants.activationSucces;
	}

}