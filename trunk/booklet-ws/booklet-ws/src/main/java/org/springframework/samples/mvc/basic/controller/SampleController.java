package org.springframework.samples.mvc.basic.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.samples.mvc.basic.model.Sample;
import org.springframework.samples.mvc.basic.service.SampleService;

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
}