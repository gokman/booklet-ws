package com.fagose.booklet.controller;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fagose.booklet.model.Action;
import com.fagose.booklet.service.ActionService;
import com.fagose.booklet.to.SearchCriteria;


@Controller
@RequestMapping("/Action")
public class ActionController{

	@Autowired
	private ActionService actionService;
	
	@RequestMapping(value = "/ADD", method = RequestMethod.POST)
	@ResponseBody
	public Action addAction(@RequestBody Action action) {
		action.setActionDate(new Date(action.getActionDateinMS()));
		actionService.addAction(action);
		
		return action;
	}	  
	@RequestMapping(value = "/LIST",method = RequestMethod.POST)
	@ResponseBody	
	public List<Action> listActions(@RequestBody SearchCriteria searchCriteria) {
		List <Action> actions = actionService.listAction(searchCriteria);
		
		return actions;		
	}
	@RequestMapping(value="/DELETE/{userId}/{detailId}", method = RequestMethod.DELETE)
	public void deleteAction(@PathVariable Long userId,@PathVariable Long detailId) throws IOException {
		actionService.deleteAction(userId, detailId);
	}
	
}
