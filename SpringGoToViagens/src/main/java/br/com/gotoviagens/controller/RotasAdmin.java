package br.com.gotoviagens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RotasAdmin {

	@GetMapping("/admin")
	// PÁGINA INICIAL DO ADMINISTRADOR
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("admin/admin.html");
		return modelAndView;
	}
	
	
	
}
