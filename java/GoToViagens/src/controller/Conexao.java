package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

// Nome do usuário do MySQL

	private static final String USERNAME = "root";

// Senha do usuário do MySQL

	private static final String PASSWORD = "";

// Dados de caminho, porta e nome da base de dados que irá ser feita a conexão

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/gotoviagens";


	public static Connection createConnectionToMySQL() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		// Cria a conexão com o banco de dados

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;

	}

}
