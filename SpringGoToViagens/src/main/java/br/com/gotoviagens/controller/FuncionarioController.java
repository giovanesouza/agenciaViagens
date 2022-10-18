package br.com.gotoviagens.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.Funcionario;
import br.com.gotoviagens.repository.CargoRepository;
import br.com.gotoviagens.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	// NECESSÁRIO PARA FAZER A RELAÇÃO COM FUNCIONÁRIO
    @Autowired
    private CargoRepository cargoRepository;

	// === CADASTRO DE USUÁRIOS

		// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
		@GetMapping("/cadastrarFuncionario")
		public ModelAndView cadastrar() {
			ModelAndView modelAndView = new ModelAndView("admin/funcionario/cadastrar");
			modelAndView.addObject("funcionarios", new Funcionario());
			
			// MOSTRA A LISTA DE CARGOS
			modelAndView.addObject("cargos", cargoRepository.findAll());
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
		
		// == EDITANDO UM CADASTRO
		// APENAS LISTA O E MOSTRA OS CAMPOS P/ EDIÇÃO
		@GetMapping("/{matricula}/editarFuncionario")
		public ModelAndView editar(@PathVariable Long matricula) {
			ModelAndView modelAndView = new ModelAndView("admin/funcionario/editar");

			Funcionario funcionarios = funcionarioRepository.getOne(matricula);
			modelAndView.addObject("funcionarios", funcionarios);
			modelAndView.addObject("cargos", cargoRepository.findAll());

			return modelAndView;
		}

		// ATUALIZA O CADASTRO
		@PostMapping("/{matricula}/editarFuncionario")
		public ModelAndView editar(Funcionario funcionarios) {
			ModelAndView modelAndView = new ModelAndView("redirect:/listarFuncionarios");
			funcionarioRepository.save(funcionarios);

			return modelAndView;
		}
	
		
		// == EXCLUI UM CADASTRO
		@GetMapping("/{matricula}/excluirFuncionario")
		public ModelAndView excluir(@PathVariable Long matricula) {
			ModelAndView modelAndView = new ModelAndView("redirect:/listarFuncionarios");
			funcionarioRepository.deleteById(matricula);
			return modelAndView;
		}
	
}
