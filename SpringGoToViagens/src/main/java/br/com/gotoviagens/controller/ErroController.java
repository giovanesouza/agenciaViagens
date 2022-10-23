package br.com.gotoviagens.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErroController implements ErrorController {

	private final static String PATH = "/error";

	@RequestMapping(PATH)
	//@ResponseBody => UTILIZADO PARA EXIBIR MSG NO CORPO DO SITE SEM A NECESSIDADE DE CRIAR UMA VIEW
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "error/error";
	}


}
