package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destino;
import model.DestinoDAO;



@WebServlet("/Destinos")
public class ListarDestinos extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Destino> destinos = new ArrayList<Destino>();
		DestinoDAO dest = new DestinoDAO();		
		destinos = dest.getDestinos();		
		request.setAttribute("listaDestinos", destinos);
		
		// REDIRECIONA PARA PÁGINA CADASTRO COM A LISTA ATUALIZADA
		// TAMBÉM POSSO FAZER UMA PAG DE CADASTRO SEM LISTAR OS DADOS E OUTRA PÁG PARA CADASTRO E EXIBIÇÃO DA LISTA.
		RequestDispatcher rd = request.getRequestDispatcher("comprarpassagem.jsp");
		rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
