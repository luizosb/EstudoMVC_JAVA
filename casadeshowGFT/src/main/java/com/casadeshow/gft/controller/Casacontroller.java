package com.casadeshow.gft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casadeshow.gft.model.Casashow;
import com.casadeshow.gft.repository.Casas;

@Controller
@RequestMapping("/home")
public class Casacontroller {
	
	@Autowired
	private Casas show;
	
	@RequestMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("Home");
		return mv;	
	}
	
	@RequestMapping("/casadeshow")
	public ModelAndView casadeshow() {
		ModelAndView mv = new ModelAndView("Casadeshow");
		return mv;
	}
	
	@RequestMapping (value = "/casadeshow", method = RequestMethod.POST)
	public ModelAndView salvar(Casashow casashow) {
		show.save(casashow);
		ModelAndView mv = new ModelAndView("Casadeshow");
		return mv;
	}
	
	
	
}
