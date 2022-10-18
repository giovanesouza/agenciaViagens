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
	
	@GetMapping("/minhasViagens")
	// PÁGINA INICIAL DO PERFIL
	public String viagens() {
		return "perfil/minhasViagens";
	}
	
	@GetMapping("/comprarPassagem")
	// PÁGINA INICIAL DO PERFIL
	public String comprar() {
		return "perfil/comprarpassagem";
	}
	
	@GetMapping("/infoCadastrais")
	// PÁGINA INICIAL DO PERFIL
	public String informacoesCadastrais() {
		return "perfil/infocadastrais";
	}
	
	@GetMapping("/excluirConta")
	// PÁGINA INICIAL DO PERFIL
	public String excluirConta() {
		return "perfil/excluirconta";
	}
	
	
	
}
