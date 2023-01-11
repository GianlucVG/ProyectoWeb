package com.restaurant.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/")
	public String listar(Model model) {
		
		return "index";
	}

}
/*
 @Controller
@RequestMapping("/platos")
public class PlatoController {
	
	@Autowired
	PlatoServiceImpl servicioPlato;
	@Autowired
	TipoPlatoServiceImpl servicioTipo;
	
	@RequestMapping("/")
	public String listar(Model model) {
		
		List<Plato> listaPlatos = servicioPlato.listarPlatos();
		List<TipoPlato> listaTipos = servicioTipo.listarTipos();
		
		model.addAttribute("platos", listaPlatos);
		model.addAttribute("tipos", listaTipos);
		
		return "plato";
	}
 
 
 
 
 */