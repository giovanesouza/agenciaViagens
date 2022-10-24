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
		ModelAndView modelAndView = new ModelAndView("admin/destinos/cadastrarDestino");
		modelAndView.addObject("destinos", new Destinos());
		return modelAndView;
	}

	@PostMapping("/cadastrarDestinos")
	public ModelAndView cadastrarDestino(Destinos destinos) throws IOException {

		ModelAndView modelAndView = new ModelAndView("admin/destinos/cadastrarDestino");
		destinosRepository.save(destinos);

		return modelAndView;
	}

	// === LISTA OS DESTINOS

	@GetMapping("/listarDestinos")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("admin/destinos/listarDestinos");

		List<Destinos> destinos = destinosRepository.findAll();
		modelAndView.addObject("destinos", destinos);

		return modelAndView;
	}

	// == EDITANDO UM CADASTRO
	// APENAS LISTA O E MOSTRA OS CAMPOS P/ EDIÇÃO
	@GetMapping("/{id}/editarDestino")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("admin/destinos/editarDestino");

		Destinos destinos = destinosRepository.getOne(id);
		modelAndView.addObject("destinos", destinos);

		return modelAndView;
	}

	// ATUALIZA O CADASTRO
	@PostMapping("/{id}/editarDestino")
	public ModelAndView editar(Destinos destinos) {
		ModelAndView modelAndView = new ModelAndView("redirect:/listarDestinos");

		destinosRepository.save(destinos);

		return modelAndView;
	}

	
	// == EXCLUI UM CADASTRO
	@GetMapping("/{id}/excluirDestino")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/listarDestinos");
		destinosRepository.deleteById(id);
		return modelAndView;
	}

	
	
	// BUSCAR PASSAGEM - VERSÃO FUNCIONAL QUE APRESENTA TODOS OS CAMPOS DO BD

	@GetMapping("/buscarPassagem")
	// RECEBE OS PARÂMETROS EMBARQUE E DESTINO PARA BUSCAR 
	public ModelAndView buscar(Model model, Destinos userParams) {

		// INSTÂNCIA DE USUÁRIO - RETORNA O OBJETO
		List<Destinos> dest = destinosRepository.BuscarPassagem(userParams.getEmbarque(), userParams.getDestino());

		//if (dest != null) {
			//return new ModelAndView("html/listaPassagem");

		//}

		//model.addAttribute("erro", "No momento não há passagens para o embarque e destino selecionado.");
		//model.addAttribute("sucesso", "Passagens localizadas.");
	
		model.addAttribute("destinos", dest);
		return new ModelAndView("site/listaPassagem");

	}
	
	
	
	
	// BUSCAR PASSAGENS
	/*@GetMapping("/buscarPassagem")
	// RECEBE MODEL E OBJETO COM O EMAIL E SENHA
	public String buscar(Model model, Destinos userParams) {

		// INSTÂNCIA DE USUÁRIO - RETORNA O OBJETO
		Destinos dest = destinosRepository.BuscarPassagem(userParams.getEmbarque(), userParams.getDestino());

		if (dest != null) {
			return "html/listaPassagem";
		}

		model.addAttribute("erro", "No momento não há passagens para o embarque e destino selecionado.");
		return "index";

	} 
	*/
	

	

}
