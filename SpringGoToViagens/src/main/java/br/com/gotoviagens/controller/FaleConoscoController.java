package br.com.gotoviagens.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		ModelAndView modelAndView = new ModelAndView("site/contato");
		modelAndView.addObject("faleConosco", new FaleConosco());
		return modelAndView;
	}
	
		
	@PostMapping("/contato")
	public ModelAndView contactar(FaleConosco faleConosco)  throws IOException {
		
		ModelAndView modelAndView = new ModelAndView("success/confirm-contato");

		faleConoscoRepository.save(faleConosco);

		return modelAndView;
	}

	
	// === LISTA AS SOLICITAÇÕES DE CONTATO

		@GetMapping("/listarContatos")
		public ModelAndView listar() {
			ModelAndView modelAndView = new ModelAndView("admin/faleConosco/listar");

			List<FaleConosco> faleConosco = faleConoscoRepository.findAll();
			modelAndView.addObject("faleConosco", faleConosco);

			return modelAndView;
		}
		
		
		// == EDITANDO UM CADASTRO
		// APENAS LISTA O E MOSTRA OS CAMPOS P/ EDIÇÃO
		@GetMapping("/{id}/editarStatusSolicitacaoContato")
		public ModelAndView editar(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("admin/faleConosco/editar");

			FaleConosco faleConosco = faleConoscoRepository.getOne(id);
			modelAndView.addObject("faleConosco", faleConosco);

			return modelAndView;
		}

		// ATUALIZA O STATUS
		@PostMapping("/{id}/editarStatusSolicitacaoContato")
		public ModelAndView editar(FaleConosco faleConosco) {
			ModelAndView modelAndView = new ModelAndView("redirect:/listarContatos");

			faleConoscoRepository.save(faleConosco);

			return modelAndView;
		}
		
		// == EXCLUI UM CADASTRO
		@GetMapping("/{id}/excluirSolicitacaoContato")
		public ModelAndView excluir(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("redirect:/listarContatos");
			faleConoscoRepository.deleteById(id);
			return modelAndView;
		}
		
	
	
}
