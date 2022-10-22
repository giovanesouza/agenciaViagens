package br.com.gotoviagens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RotasPerfil {
	

	@GetMapping("/perfil")
	// PÁGINA INICIAL DO PERFIL
	public String perfilHome() {
		return "perfil/inicio";
	}
	
	
	/* EXCLUIR
	@GetMapping("/minhasViagens")
	// PÁGINA INICIAL DO PERFIL
	public String viagens() {
		return "perfil/minhasViagens";
	}
	*/
	
	
	
	
	@GetMapping("/comprarPassagem")
	// PÁGINA COMPRAR PASSAGENS
	public String comprar() {
		return "perfil/comprarpassagem";
	}
		
	
	
}
