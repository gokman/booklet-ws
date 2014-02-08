package com.fagose.booklet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fagose.booklet.model.Action;
import com.fagose.booklet.service.ActionService;


@Controller
@RequestMapping("/Action")
public class ActionController{

	@Autowired
	private ActionService actionService;
	
	@RequestMapping(value = "/ADD", method = RequestMethod.POST)
	@ResponseBody
	public Action addAction(@RequestBody Action action) {

		actionService.addAction(action);
		
		return action;
	}	  
	  
}
