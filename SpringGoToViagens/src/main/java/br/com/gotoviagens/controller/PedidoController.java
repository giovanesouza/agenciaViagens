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
import br.com.gotoviagens.model.Destinos;
import br.com.gotoviagens.model.Pedido;
import br.com.gotoviagens.model.Usuario;
import br.com.gotoviagens.repository.DestinosRepository;
import br.com.gotoviagens.repository.PedidoRepository;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private DestinosRepository destinosRepository;
	
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
	@PostMapping("/{id}/realizarPedido")
	public ModelAndView cadastrarDestino(Pedido pedido) throws IOException {

		ModelAndView modelAndView = new ModelAndView("perfil/minhasviagens");
		pedidoRepository.save(pedido);

		return modelAndView;
	}
	
	
	
	
	// EXIBE LISTA COM AS PASSAGENS COMPRADAS
	@GetMapping("/minhasViagens")

	public ModelAndView viagens(Usuario usuario, @PathVariable Long id) {
		ModelAndView mv = new ModelAndView("perfil/minhasviagens");
		List<Pedido> pedidos = pedidoRepository.buscarPedidosById(usuario.getId());
		mv.addObject("pedidos", pedidos);
		return mv;
	}
	
	
	
	
}
