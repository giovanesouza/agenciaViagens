package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioDAO;


@WebServlet("/ExcluirConta")
public class ExcluirConta extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idUsuario = Integer.parseInt(request.getParameter("id"));

		UsuarioDAO udao = new UsuarioDAO();

		udao.removeById(idUsuario);

		response.sendRedirect("delete-success-profile.html");
		
	}



}
