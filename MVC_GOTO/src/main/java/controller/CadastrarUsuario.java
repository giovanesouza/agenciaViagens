package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioDAO;


@WebServlet("/CadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// recebendo os dados do formulario via parametro
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		// criando o objeto contato 
		Usuario u =  new Usuario();
		
		// guardando os dados do formulario do objeto
		u.setNome(nome);
		u.setCpf(cpf);
		u.setEmail(email);
		u.setSenha(senha);
		u.setDataCadastro(new Date());
		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		UsuarioDAO udao = new UsuarioDAO();		
		udao.save(u);
		
		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("success.html");
		
	}

}
