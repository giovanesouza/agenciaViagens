
/*

package br.com.gotoviagens.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

//import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.Usuario;
import br.com.gotoviagens.repository.UsuarioRepository;
import br.com.gotoviagens.service.SerciveExc;
import br.com.gotoviagens.service.ServiceUsuario;
import br.com.gotoviagens.util.Util;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// INJECÇÃO DE DEPENDÊNCIAS
	@Autowired
	private ServiceUsuario serviceUsuario;

*/

	// === CADASTRO DE USUÁRIOS
	/*
	 * // CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	 * 
	 * @GetMapping("/cadastrarUsuario") public ModelAndView cadastrar() {
	 * ModelAndView modelAndView = new ModelAndView("html/cadastrarUsuario");
	 * modelAndView.addObject("usuario", new Usuario()); return modelAndView; }
	 * 
	 * /*
	 * 
	 * @PostMapping("/cadastrarUsuario") public ModelAndView cadastrar(Usuario
	 * usuario) {
	 * 
	 * ModelAndView modelAndView = new
	 * ModelAndView("success/confirm-cadastroUsuario");
	 * 
	 * usuarioRepository.save(usuario);
	 * 
	 * return modelAndView; }
	 */

	/*
	
	// PÁGINA DE LOGIN
	@GetMapping("/login")
	// PÁGINA LOGIN
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("html/login1");
		return mv;
	}

	// === CADASTRO DE USUÁRIOS

	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrarUsuario")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("html/cadastrarUsuario");
		// mv.setViewName("pasta/arquivo"); Também posso chamar uma view dessa forma
		return mv;
	}

	@PostMapping("/cadastrarUsuario")
	public ModelAndView cadastrar(Usuario usuario) throws Exception {

		// REDIRECIONAR PARA LOGIN
		// ModelAndView mv = new ModelAndView("success/confirm-cadastroUsuario");
		ModelAndView mv = new ModelAndView();
		serviceUsuario.salvarUsuario(usuario);
		// usuarioRepository.save(usuario); AGORA QUEM FAZ O CADASTRO É O SERVICEUSUARIO

		// QUANDO SALVAR VAI REDIRECIONAR PARA INDEX
		mv.setViewName("redirect:/login");
		return mv;
	}
	
	
	// LOGAR
	
	@PostMapping("/logar")
	public ModelAndView logar(@Validated Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, SerciveExc  {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		
		// EM CASO DE ERRO NAS VALIDAÇÕES, REDIRECIONA PARA PÁGINA ESPECIFICADA
		if (br.hasErrors()) {
			mv.setViewName("html/login1");
		}
		
		// TEM O MÉTODO QUE PESQUISA POR USUÁRIO
		// COMPARA OS DADOS DIGITADOS COM O BD
		Usuario userLogin = serviceUsuario.loginUser(usuario.getEmail(), Util.md5(usuario.getSenha()));
		
		// CASO O USUÁRIO SEJA NULO => msg de erro, SENÃO, set a sessão.
		if (userLogin == null) {
			mv.addObject("msg", "Usuário não encontrado! Tente novamente.");
		} else {
			session.setAttribute("usuarioLogado", userLogin);
			return perfilHome();
		}
		
		return mv;
		
		
	}
	
	
	// LOGOUT
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return login();
		
	}
	
	
	
	
	
	
	// PÁGINA INICIAL DO PERFIL
	
	@GetMapping("/perfil")
	// PÁGINA INICIAL DO PERFIL
	public ModelAndView perfilHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("perfil/inicio");
		mv.addObject("usuario", new Usuario());
		
		//Usuario user = (Usuario) session.getAttribute("usuarioLogado");
		
		//model.addAttribute("nome", CookieService.getCookie(request, "nomeUsuario"));
		
		return mv;
	}
	
	
	
	

}
*/
