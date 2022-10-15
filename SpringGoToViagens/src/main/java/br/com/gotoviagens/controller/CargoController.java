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
import br.com.gotoviagens.repository.CargoRepository;

@Controller
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	
	// === CADASTRO DE CARGOS

		// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
		@GetMapping("/cadastrarCargo")
		public ModelAndView cadastrar() {
			ModelAndView modelAndView = new ModelAndView("admin/cargo/cadastrar");
			modelAndView.addObject("cargos", new Cargo());
			return modelAndView;
		}

		@PostMapping("/cadastrarCargo")
		public ModelAndView cadastrar(Cargo cargos) throws IOException {

			ModelAndView modelAndView = new ModelAndView("redirect:/listarCargos");
			cargoRepository.save(cargos);
			return modelAndView;
		}

		
		@GetMapping("/listarCargos")
		public ModelAndView listar() {
			ModelAndView modelAndView = new ModelAndView("admin/cargo/listar");

			List<Cargo> cargos = cargoRepository.findAll();
			modelAndView.addObject("cargos", cargos);

			return modelAndView;
		}
		
		
		// == EDITANDO UM CADASTRO
		// APENAS LISTA O E MOSTRA OS CAMPOS P/ EDIÇÃO
		@GetMapping("/{id}/editarCargo")
		public ModelAndView editar(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("admin/cargo/editar");

			Cargo cargos = cargoRepository.getOne(id);
			modelAndView.addObject("cargos", cargos);

			return modelAndView;
		}

		// ATUALIZA O CADASTRO
		@PostMapping("/{id}/editarCargo")
		public ModelAndView editar(Cargo cargos) {
			ModelAndView modelAndView = new ModelAndView("redirect:/listarCargos");
			cargoRepository.save(cargos);

			return modelAndView;
		}

		
		// == EXCLUI UM CADASTRO
		@GetMapping("/{id}/excluirCargo")
		public ModelAndView excluir(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("redirect:/listarCargos");
			cargoRepository.deleteById(id);
			return modelAndView;
		}
		
		
}
