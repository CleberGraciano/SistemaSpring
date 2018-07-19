package com.example.projetos.ProjetoEvento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.projetos.ProjetoEvento.models.Evento;
import com.example.projetos.ProjetoEvento.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository eventorepository;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	String form() {
		return "evento/formEvento";

	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	String form(Evento evento) {

		eventorepository.save(evento);

		return "redirect:/cadastrarEvento";

	}
	
	@RequestMapping("/eventos")
	public  ModelAndView listaEventos() {
		
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = eventorepository.findAll();
		mv.addObject("eventos",eventos);
		return mv;
		
	}
	
	

}
