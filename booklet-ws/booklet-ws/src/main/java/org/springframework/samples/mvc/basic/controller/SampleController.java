package org.springframework.samples.mvc.basic.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.samples.mvc.basic.model.Sample;
import org.springframework.samples.mvc.basic.service.SampleService;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/sample")
public class SampleController{
	
	@Autowired
	private SampleService sampleService;

	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String listSample(ModelMap model) {
		model.addAttribute("sampleList", sampleService.listSample());
		return "services/listSample";

	}
	
	@RequestMapping(value="/listJson", method = RequestMethod.GET)
	@ResponseBody
	public List<Sample> listSampleJson(ModelMap model) {
		return sampleService.listSample();
	}
	
	@RequestMapping(value = "/addSample",
	           method = RequestMethod.POST)
	 @ResponseBody
	 public Sample addPerson(@RequestBody Sample sample) {
	     
	     sampleService.addSample(sample);
	     return sample;
	    }
	
	@RequestMapping(value = "/deleteSample/{id}",
	           method = RequestMethod.DELETE)
	 @ResponseBody
	 public String deletePerson(@PathVariable("id") Long id) {
	     
	     sampleService.deleteSample(id);
	     return "dene";
	    }
	
	@RequestMapping(value = "/deleteSample2",
	           method = RequestMethod.DELETE)
	 @ResponseBody
	 public String deletePerson2() {
	
	    Sample sample1 = new Sample((long)25,"name");
	    sample1.setSampleSurname("surname");
	    
	    sampleService.deleteSample2(sample1);
	 
	    return "dene";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	@ResponseBody
	public String login(ModelMap model) {
		String userName=SecurityContextHolder.getContext().getAuthentication().getName();

		return userName;
	}
	
}