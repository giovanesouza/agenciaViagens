package br.com.gotoviagens.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.Usuario;
import br.com.gotoviagens.repository.UsuarioRepository;

@Controller
public class EsqueciSenhaController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/alterarSenha")
	// PÁGINA INICIAL DO ADMINISTRADOR
	public ModelAndView alterarSenha(Usuario usuario) {
		ModelAndView mv = new ModelAndView("site/esqueciSenha");
		mv.addObject("usuario", usuario);

		return mv;
	}

	// BUSCA O USUÁRIO PELO E-MAIL E CPF
	@PostMapping("/alterarSenha")
	public ModelAndView buscar(Model model, Usuario userParams, HttpSession session) {

		ModelAndView mv = new ModelAndView("site/esqueciSenha");

		// INSTÂNCIA DE USUÁRIO - RETORNA O OBJETO
		Usuario user = usuarioRepository.findByEmailCpf(userParams.getEmail(), userParams.getCpf());

		if (user != null) {
			session.setAttribute("alterarSenhaUser", user);
			return new ModelAndView("site/mudarSenha");

		}

		model.addAttribute("erro", "Os dados não conferem!");
		return mv;

	}
	
	

	// ATUALIZA O CADASTRO
	@PostMapping("/senhaAlterada")
	public ModelAndView editar(Usuario usuario, Model model) {
		ModelAndView mv = new ModelAndView("redirect:/login");

		usuarioRepository.save(usuario);
		return mv;
	}

}
