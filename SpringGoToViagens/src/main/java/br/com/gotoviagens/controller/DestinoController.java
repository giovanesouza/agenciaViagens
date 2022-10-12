package br.com.gotoviagens.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.Destinos;
import br.com.gotoviagens.repository.DestinosRepository;


@Controller
public class DestinoController {
	
	@Autowired
	private DestinosRepository destinosRepository;

	// === CADASTRO DE USUÁRIOS

	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrarDestinos")
	public ModelAndView cadastrarDestino() {
		ModelAndView modelAndView = new ModelAndView("admin/cadastrarDestino");
		modelAndView.addObject("destinos", new Destinos());
		return modelAndView;
	}
	
	@PostMapping("/cadastrarDestinos")
	public ModelAndView cadastrarDestino(Destinos destinos) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/cadastrarDestino");

		destinosRepository.save(destinos);

		return modelAndView;
	}
	
}
