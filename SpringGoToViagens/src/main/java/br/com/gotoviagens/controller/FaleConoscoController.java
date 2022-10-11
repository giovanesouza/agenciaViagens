package br.com.gotoviagens.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.FaleConosco;
import br.com.gotoviagens.repository.FaleConoscoRepository;

@Controller
public class FaleConoscoController {

	@Autowired
	private FaleConoscoRepository faleConoscoRepository;

	// === CADASTRO DE SOLICITAÇÕES DE CONTATO

	// CHAMA A VIEW C E PASSA UM OBJETO VAZIO
	@GetMapping("/contato")
	public ModelAndView contactar() {
		ModelAndView modelAndView = new ModelAndView("html/contato");
		modelAndView.addObject("faleConosco", new FaleConosco());
		return modelAndView;
	}
	
		
	@PostMapping("/contato")
	public ModelAndView contactar(FaleConosco faleConosco)  throws IOException {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/contato");

		faleConoscoRepository.save(faleConosco);

		return modelAndView;
	}
	
	
}
