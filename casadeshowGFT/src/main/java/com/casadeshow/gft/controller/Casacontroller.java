package com.casadeshow.gft.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casadeshow.gft.model.Eventos;
import com.casadeshow.gft.model.Genero;
import com.casadeshow.gft.model.Local;
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
	public ModelAndView salvar(Eventos casashow) {
		show.save(casashow);
		ModelAndView mv = new ModelAndView("Casadeshow");
		mv.addObject("mensagem", "Evento marcado com sucesso!");
		return mv;
	}

	@RequestMapping
	public ModelAndView pesquisar() {
		List<Eventos> todosEventos = show.findAll();
		ModelAndView mv = new ModelAndView("Eventos");
		mv.addObject("eventos", todosEventos);				
		return mv;
	}
	
	@ModelAttribute("todosLocais")
	public List<Local> todosLocais(){
		return Arrays.asList(Local.values());
	}
	
	@ModelAttribute("todosGeneros")
	public List<Genero> todosGeneros(){
		return Arrays.asList(Genero.values());	
	}
	@RequestMapping("/eventos")
	public ModelAndView eventos() {
		ModelAndView mv = new ModelAndView("Eventos");
		return mv;
	}
}
	

