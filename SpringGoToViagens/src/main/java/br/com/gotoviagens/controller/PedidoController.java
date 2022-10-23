package br.com.gotoviagens.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gotoviagens.model.Cargo;
import br.com.gotoviagens.model.Destinos;
import br.com.gotoviagens.model.Pedido;
import br.com.gotoviagens.model.Usuario;
import br.com.gotoviagens.repository.DestinosRepository;
import br.com.gotoviagens.repository.PedidoRepository;
import br.com.gotoviagens.repository.UsuarioRepository;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private DestinosRepository destinosRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// === REALIZANDO PEDIDO

	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/{id}/realizarPedido")
	public ModelAndView realizarPedido(@PathVariable Long id) {
		
		ModelAndView modelAndView = new ModelAndView("perfil/pedido");

		Destinos destinos = destinosRepository.getOne(id);

		// PARA EXIBIR AS INFORMAÇÕES DA PASSAGEM
		modelAndView.addObject("destinos", destinos);
		
		// PARA CRIAR UM PEDIDO
		modelAndView.addObject("pedido", new Pedido());
		
		return modelAndView;
	}
	
	
	// SALVA O PEDIDO NO BD

	@PostMapping("/pedidoRealizado")
	public ModelAndView cadastrarDestino(Pedido pedido) throws IOException {

		ModelAndView modelAndView = new ModelAndView("perfil/success-compra");
		
		
		// PARA EXIBIR AS INFORMAÇÕES DO PEDIDO
		modelAndView.addObject("pedidos", pedido);	
		
		pedidoRepository.save(pedido);

		return modelAndView;
	}

	
	
	/*
	// EXIBE LISTA COM AS PASSAGENS COMPRADAS
	@GetMapping("/minhasViagens")

	public ModelAndView viagens(Usuario userParams) {
		
		ModelAndView mv = new ModelAndView("perfil/minhaspassagens");
		
		//List<Pedido> pedidos = pedidoRepository.buscarPedidosPorIdUser(userParams.getId());
		List<Pedido> pedidos = pedidoRepository.findAll();
		mv.addObject("pedidos", pedidos);
		
		return mv;
	}
	
	*/
	
	@GetMapping("/{id}/minhasPassagens")
	public ModelAndView minhasPassagens(@PathVariable Long id) {
		
		ModelAndView mv = new ModelAndView("perfil/minhaspassagens");
				
		//List<Pedido> pedidos = pedidoRepository.buscarPedidosPorIdUser(userParams.getId());
		List<Pedido> pedidos = pedidoRepository.findByUserId(id);
		mv.addObject("pedidos", pedidos);
		mv.addObject("destinos", destinosRepository.findById(id));

		return mv;
	}
	
	
	
	
}
