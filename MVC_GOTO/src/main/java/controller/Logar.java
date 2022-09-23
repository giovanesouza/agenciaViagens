package controller;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import model.UsuarioDAO;

@WebServlet("/Logar")
public class Logar extends HttpServlet {

	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PÁGINA PARA FAZER O LOGIN - A REQUISIÇÃO É ENCAMINHADA PARA ESTA PÁGINA

		// RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); // CAMINHO
		// DO ARQUIVO DE LOGIN
		// rd.forward(request, response); // ENCAMINHA P/ PAGE

	}
	*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PROCESSA O LOGIN

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		
		// ACESSANDO A DAO
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario u = new Usuario();

		u = usuarioDAO.buscarUsuarioPorEmail(email);

		boolean logado = false;


		if(u != null && u.getSenha().equals(senha)) {
			
			logado = true;
									
		} 
		
		if (logado) {
			
			// SESSÃO PARA GUARDAR OS DADOS DO USUÁRIO
			HttpSession session = request.getSession();
			
			// ATRIBUTO = "USUÁRIOLOGADO" QUE RECEBE O VALOR DE U.
			session.setAttribute("usuarioLogado", u);
			
			 // SE LOGIN FOR TRUE, USUÁRIO LOGA 		
			RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
			rd.forward(request, response);

			
		} else {
			
			logado = false; 
			
			// A VARIÁVEL ERRO RECEBE O VALOR DAS ASPAS
			request.setAttribute("erro", "E-mail e/ou Senha incorretos");
			RequestDispatcher rd = request.getRequestDispatcher("login1.jsp");
			rd.forward(request, response); // ENCAMINHA P/ PAGE
			
		}		
		




	}

}
