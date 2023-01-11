package com.restaurant.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {
	
	@RequestMapping("/login")
	public String login() {
		
		return "inicio";
	}
	@RequestMapping("/intranet")
	public String intranet() {
		
		return "/platos";
	}
}

