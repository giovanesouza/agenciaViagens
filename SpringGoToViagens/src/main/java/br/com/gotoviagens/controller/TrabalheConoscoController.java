package br.com.gotoviagens.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.Cargo;
import br.com.gotoviagens.model.TrabalheConosco;

import br.com.gotoviagens.repository.TrabalheConoscoRepository;

@Controller
public class TrabalheConoscoController {

	@Autowired
	private TrabalheConoscoRepository trabalheConoscoRepository;

	// === CADASTRO RESERVA DE FUNCIONÁRIOS (CANDIDATOS)

	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/trabalheconosco")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("site/trabalheconosco");
		modelAndView.addObject("trabalheConosco", new TrabalheConosco());
		return modelAndView;
	}

	@PostMapping("/trabalheconosco")
	public ModelAndView cadastrar(TrabalheConosco curriculo) throws IOException {

		ModelAndView modelAndView = new ModelAndView("success/confirm-trabalheconosco");

		trabalheConoscoRepository.save(curriculo);

		return modelAndView;
	}
	
	@GetMapping("/listarCandidatos")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("admin/trabalheconosco/listar");

		List<TrabalheConosco> trabalheConosco = trabalheConoscoRepository.findAll();
		modelAndView.addObject("trabalheConosco", trabalheConosco);

		return modelAndView;
	}
	
	// == EXCLUI UM CADASTRO
	@GetMapping("/{id}/excluirCandidato")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/listarCandidatos");
		trabalheConoscoRepository.deleteById(id);
		return modelAndView;
	}

}
