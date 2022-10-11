package br.com.gotoviagens.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.Usuario;
import br.com.gotoviagens.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@GetMapping("/login")
	// PÁGINA LOGIN
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("html/login1");
		return modelAndView;
	}
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	// === CADASTRO DE USUÁRIOS

	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrarUsuario")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("html/cadastrar");
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
		
	@PostMapping("/cadastrarUsuario")
	public ModelAndView cadastrar(Usuario usuario)  throws IOException {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/login");

		usuarioRepository.save(usuario);

		return modelAndView;
	}

	
}
