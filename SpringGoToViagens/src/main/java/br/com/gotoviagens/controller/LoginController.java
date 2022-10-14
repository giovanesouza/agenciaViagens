package br.com.gotoviagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.gotoviagens.model.Usuario;
import br.com.gotoviagens.repository.UsuarioRepository;


@Controller
public class LoginController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/login")
	// PÁGINA LOGIN
	public String login(Model model) {
		return "html/login1";
	}
	
	
	@PostMapping("/logar")
	// RECEBE MODEL E OBJETO COM O EMAIL E SENHA
	public String logar(Model model, Usuario userParams, String lembrar) {
		
		// INSTÂNCIA DE USUÁRIO - RETORNA O OBJETO
		Usuario user = this.usuarioRepository.Login(userParams.getEmail(), userParams.getSenha());
		
		if(user != null) {
			return "redirect:/perfil";
		}
		model.addAttribute("erro", "Email e/ou senha inválidos!");
		return "html/login1";
	}
	
	
}
