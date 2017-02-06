package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.websystique.springmvc.model.Actor;


@Controller
public class ActorController {
	
	@RequestMapping (value="/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(){
		
		ModelAndView mav = new ModelAndView("edit");
		return mav;
	}
	
	
	
	
}
