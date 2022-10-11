package br.com.gotoviagens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RotasController {

	// ROTAS PRINCIPAIS
	
	@GetMapping("/")
	// INICIALIZA A APLICAÇÃO
	public String index() {
		return "index";
	}
	
	@GetMapping("/promocoes")
	// PÁGINA PROMOÇÕES
	public ModelAndView promocoes() {
		ModelAndView modelAndView = new ModelAndView("html/promocoes");
		return modelAndView;
	}
	
	@GetMapping("/destinos")
	// PÁGINA DESTINOS
	public ModelAndView destinos() {
		ModelAndView modelAndView = new ModelAndView("html/destinos");
		return modelAndView;
	}
		
	
	// ROTAS RODAPÉ
	@GetMapping("/quemsomos")
	// PÁGINA QUEM SOMOS
	public ModelAndView quemsomos() {
		ModelAndView modelAndView = new ModelAndView("html/quemsomos");
		return modelAndView;
	}
	
	@GetMapping("/centralajuda")
	// PÁGINA CENTRAL DE AJUDA
	public ModelAndView centralajuda() {
		ModelAndView modelAndView = new ModelAndView("html/centralajuda");
		return modelAndView;
	}
	
	@GetMapping("/termoscondicoes")
	// PÁGINA TERMOS E CONDIÇÕES
	public ModelAndView termoscondicoes() {
		ModelAndView modelAndView = new ModelAndView("html/termoscondicoes");
		return modelAndView;
	}
	
	@GetMapping("/duvidas")
	// PÁGINA DÚVIDAS
	public ModelAndView duvidas() {
		ModelAndView modelAndView = new ModelAndView("html/duvidas");
		return modelAndView;
	}
	
	
	@GetMapping("/trabalheconosco")
	// PÁGINA TRABALHE CONOSCO
	public ModelAndView trabalheconosco() {
		ModelAndView modelAndView = new ModelAndView("html/trabalheconosco");
		return modelAndView;
	}
	
	
	
	
	
}
