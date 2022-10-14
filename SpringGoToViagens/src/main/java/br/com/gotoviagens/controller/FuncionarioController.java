package br.com.gotoviagens.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.Departamento;
import br.com.gotoviagens.model.Funcionario;
import br.com.gotoviagens.repository.FuncionarioRepository;



@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	// === CADASTRO DE USUÁRIOS

		// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
		@GetMapping("/cadastrarFuncionario")
		public ModelAndView cadastrar() {
			ModelAndView modelAndView = new ModelAndView("admin/funcionario/cadastrar");
			modelAndView.addObject("funcionarios", new Funcionario());
			return modelAndView;
		}

		@PostMapping("/cadastrarFuncionario")
		public ModelAndView cadastrar(Funcionario funcionarios) throws IOException {

			ModelAndView modelAndView = new ModelAndView("redirect:/listarFuncionarios");
			funcionarioRepository.save(funcionarios);
			return modelAndView;
		}
		
		// === LISTA OS DEPARTAMENTOS

		@GetMapping("/listarFuncionarios")
		public ModelAndView listar() {
			ModelAndView modelAndView = new ModelAndView("admin/funcionario/listar");

			List<Funcionario> funcionarios = funcionarioRepository.findAll();
			modelAndView.addObject("funcionarios", funcionarios);

			return modelAndView;
		}
	
	
}
