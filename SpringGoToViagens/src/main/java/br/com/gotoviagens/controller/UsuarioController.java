package br.com.gotoviagens.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.Usuario;
import br.com.gotoviagens.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	// === CADASTRO DE USUÁRIOS

	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrarUsuario")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("html/cadastrarUsuario");
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
			
	@PostMapping("/cadastrarUsuario")
	public ModelAndView cadastrar(Usuario usuario)  throws IOException {
		
		ModelAndView modelAndView = new ModelAndView("success/confirm-cadastroUsuario");

		usuarioRepository.save(usuario);

		return modelAndView;
	}
	
	
	// ATUALIZA O CADASTRO
	
	@GetMapping("/infoCadastrais")
	// PÁGINA INFORMAÇÕES CADASTRAIS
	public String informacoesCadastrais() {
		return "perfil/infocadastrais";
	}
	
	@PostMapping("/infoCadastrais")
	// PÁGINA INICIAL DO PERFIL
	public ModelAndView editar(Usuario usuario, Model model) {
		ModelAndView mv = new ModelAndView("redirect:/infoCadastrais");
		
		model.addAttribute("sucesso", "Atualização realizada com sucesso! As informações atualizadas aparecerão no próximo acesso/login.");
		usuarioRepository.save(usuario);
		
		return mv;
	}
	

	// EXCLUI CONTA

	@GetMapping("/excluirConta")
	// PÁGINA INICIAL DO PERFIL
	public String excluirConta() {
		return "perfil/excluirconta";
	}
	
	@PostMapping("/perfilExcluidoComSucesso")
	public ModelAndView excluir(Usuario usuario) {
		ModelAndView mv = new ModelAndView("success/confirm-delete-perfilUsuario");
		
		usuarioRepository.delete(usuario);
		return mv;
	}
	
	
	
}
