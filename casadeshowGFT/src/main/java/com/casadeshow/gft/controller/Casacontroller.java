package com.casadeshow.gft.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casadeshow.gft.model.Eventos;
import com.casadeshow.gft.model.Genero;
import com.casadeshow.gft.model.Local;
import com.casadeshow.gft.repository.Casas;
import com.casadeshow.gft.repository.filter.EventoFilter;
import com.casadeshow.gft.services.EventoService;

@Controller
@RequestMapping("/home")
public class Casacontroller {
	
	
	private static final String EVENTO_VIEW = "Eventos";
	private static final String CASA_VIEW = "Casadeshow";
	private static final String HISTORICO_VIEW = "Historico";
	
	@Autowired
	private Casas show;
	
	@Autowired
	private EventoService eventoService;
	
	@RequestMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("Home");
		return mv;	
	}
	
	
	//Casa de Show controller
	
	@RequestMapping("/casadeshow")
	public ModelAndView casadeshow() {
		ModelAndView mv = new ModelAndView("Casadeshow");
		mv.addObject(new Eventos());
		return mv;
	}
	
	
	@RequestMapping (value = "/casadeshow", method = RequestMethod.POST)
	public String salvar(@Validated Eventos eventos, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return "Casadeshow";
		}
		
		
		try {
		eventoService.salvar(eventos);
		attributes.addFlashAttribute("mensagem", "Evento marcado com sucesso!");
		return "redirect:/home/casadeshow";
		} catch(IllegalArgumentException e) {
			errors.rejectValue("data", null, e.getMessage());
			return CASA_VIEW;
		}
	}
	
	@ModelAttribute("todosLocais")
	public List<Local> todosLocais(){
		return Arrays.asList(Local.values());
	}
	
	@ModelAttribute("todosGeneros")
	public List<Genero> todosGeneros(){
		return Arrays.asList(Genero.values());	
	}
	
	//Eventos Controller
		
	@RequestMapping("/eventos")
	public ModelAndView eventospesquisar(@ModelAttribute("filtro") EventoFilter filtro) {
		List<Eventos> todosEventos = eventoService.filtrar(filtro);
		ModelAndView mv = new ModelAndView(EVENTO_VIEW);
		mv.addObject("eventos", todosEventos);				
		return mv;
	}
	
	@RequestMapping(value= "/casadeshow/{codigo}")
	public ModelAndView edicao(@PathVariable Long codigo, Optional<Eventos> eventos) {
		ModelAndView mv = new ModelAndView(CASA_VIEW);
		mv.addObject(eventos.get());
		return mv;
	}
	
	@RequestMapping(value ="/eventos/{codigo}")
	public ModelAndView excluir(@PathVariable Long codigo, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/home/eventos");
		eventoService.excluir(codigo);
		attributes.addFlashAttribute("mensagem", "Evento excluido com sucesso!");
		return mv;
	}
	
	//Histórico Controller
	
	@RequestMapping("/historico")
	public ModelAndView historico() {
		ModelAndView mv = new ModelAndView(HISTORICO_VIEW);
		return mv;
	}
	
	
	
	
}