package br.com.gotoviagens.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.Destinos;

import br.com.gotoviagens.model.Usuario;
import br.com.gotoviagens.repository.DestinosRepository;
import br.com.gotoviagens.repository.UsuarioRepository;
import br.com.gotoviagens.util.SenhaUtil;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DestinosRepository destinosRepository;

	// === CADASTRO DE USUÁRIOS

	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrarUsuario")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("site/cadastrarUsuario");
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}

	/*
	 * @PostMapping("/cadastrarUsuario") public ModelAndView cadastrar(Usuario
	 * usuario) throws IOException {
	 * 
	 * ModelAndView modelAndView = new
	 * ModelAndView("success/confirm-cadastroUsuario");
	 * 
	 * usuarioRepository.save(usuario);
	 * 
	 * return modelAndView; }
	 */


	@PostMapping("/cadastrarUsuario")
	public ModelAndView cadastrar(Usuario usuario, Model model)  throws IOException {
			
		ModelAndView modelAndView = new	ModelAndView("success/confirm-cadastroUsuario");

		// CRIPTOGRAFA SENHA
		//String senhaEncriptada = SenhaUtil.encode(usuario.getSenha());
		//String senhaCriptografada = SenhaUtil.encode(usuario.getSenha());
			
		// VERIFICAÇÃO PARA SABER SE O USUÁRIO JÁ TEM E-MAIL CADASTRADO
		
		try {
			
			if(usuarioRepository.findByCpf(usuario.getCpf()) != null) {
				ModelAndView mv = new	ModelAndView("site/cadastrarUsuario");
				model.addAttribute("msg", "Já existe um cadastro para o CPF informado: " + usuario.getCpf() + ".");
				return mv;
				//throw new EmailExistsException("Este e-mail já foi cadastrado para um usuário: " + usuario.getCpf());
			};
				
		} finally {
			
		}
		
		
		// usuario.setSenha(senhaCriptografada);
		 
		// CADASTRA NOVO USUÁRIO
		usuarioRepository.save(usuario);
		return modelAndView;
		
	}
	

			

	// === LISTA OS USUÁRIOS - NO ADM

	@GetMapping("/listarUsuarios")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("admin/usuario/listar");

		List<Usuario> usuarios = usuarioRepository.findAll();
		modelAndView.addObject("usuarios", usuarios);

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

	@GetMapping("/perfil/buscarPassagem")
	// RECEBE MODEL E OBJETO COM O EMAIL E SENHA
	public ModelAndView buscar(Model model, Destinos userParams) {

		// INSTÂNCIA DE USUÁRIO - RETORNA O OBJETO
		List<Destinos> dest = destinosRepository.BuscarPassagem(userParams.getEmbarque(), userParams.getDestino());

		if (dest != null) {
			model.addAttribute("msg", "Passagens localizadas!");
			// return new ModelAndView("html/listaPassagem");

		}

		if (dest == null) {
			model.addAttribute("msg", "No momento não há passagens para o embarque e destino selecionado.");
			// model.addAttribute("sucesso", "Passagens localizadas.");
		}
		model.addAttribute("destinos", dest);
		return new ModelAndView("perfil/comprarpassagem");

	}

}
