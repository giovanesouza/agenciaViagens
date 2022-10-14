package br.com.gotoviagens.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.Departamento;
import br.com.gotoviagens.model.Destinos;
import br.com.gotoviagens.model.FaleConosco;
import br.com.gotoviagens.repository.DepartamentoRepository;

@Controller
public class DepartamentosController {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	// === CADASTRO DE DEPARTAMENTOS

	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrarDepartamento")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("admin/departamentos/cadastrar");
		modelAndView.addObject("departamentos", new Departamento());
		return modelAndView;
	}

	@PostMapping("/cadastrarDepartamento")
	public ModelAndView cadastrar(Departamento departamentos) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/listarDepartamentos");
		departamentoRepository.save(departamentos);
		return modelAndView;
	}

	// === LISTA OS DEPARTAMENTOS

	@GetMapping("/listarDepartamentos")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("admin/departamentos/listar");

		List<Departamento> departamentos = departamentoRepository.findAll();
		modelAndView.addObject("departamentos", departamentos);

		return modelAndView;
	}

	// == EDITANDO UM CADASTRO
	// APENAS LISTA O E MOSTRA OS CAMPOS P/ EDIÇÃO
	@GetMapping("/{codDepartamento}/editarDepartamento")
	public ModelAndView editar(@PathVariable Long codDepartamento) {
		ModelAndView modelAndView = new ModelAndView("admin/departamentos/editar");

		Departamento departamentos = departamentoRepository.getOne(codDepartamento);
		modelAndView.addObject("departamentos", departamentos);

		return modelAndView;
	}

	// ATUALIZA O CADASTRO
	@PostMapping("/{codDepartamento}/editarDepartamento")
	public ModelAndView editar(Departamento departamentos) {
		ModelAndView modelAndView = new ModelAndView("redirect:/listarDepartamentos");
		departamentoRepository.save(departamentos);

		return modelAndView;
	}

	
	// == EXCLUI UM CADASTRO
	@GetMapping("/{codDepartamento}/excluirDepartamento")
	public ModelAndView excluir(@PathVariable Long codDepartamento) {
		ModelAndView modelAndView = new ModelAndView("redirect:/listarDepartamentos");
		departamentoRepository.deleteById(codDepartamento);
		return modelAndView;
	}
	
	
}
