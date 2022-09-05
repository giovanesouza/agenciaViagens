package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gotoviagens.Cliente;

public class ClienteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// EDITAR <=======
	public void save(Cliente cliente) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		// EDITAR <=======
		String sql = "INSERT INTO cliente(cpf_cli,nome_cli,email_cli,telefone_cli)" + " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// EDITAR <======= SET TIPO + GET DA CLASSE SEM O DAO
			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getTelefone());
			
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
			
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	// EDITAR <=======
	public void removeByCpf(String cpf) {

		String sql = "DELETE FROM cliente WHERE cpf_cli = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// TIPO DE VALOR REFERENTE AO CPF E 1 = QTD QUE SERÁ EXCLUÍDA
			pstm.setString(1, cpf);

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
			
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	// EDITAR <=======
	public void update(Cliente cliente) {
		
		String sql = "UPDATE cliente SET nome_cli = ?, email_cli = ?, telefone_cli = ?"
		+ " WHERE cpf_cli = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// EDITAR <=======
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getTelefone());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setString(4, cliente.getCpf());
			
			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
	
	// EDITAR <=======
	public List<Cliente> getClientes() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> clientes = new ArrayList<Cliente>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Cliente cliente = new Cliente();

				// Recupera o id do banco e atribui ele ao objeto
				cliente.setCpf(rset.getString("cpf_cli"));

				// Recupera o nome do banco e atribui ele ao objeto
				cliente.setNome(rset.getString("nome_cli"));

				// Recupera a idade do banco e atribui ele ao objeto
				cliente.setEmail(rset.getString("email_cli"));
				
				// Recupera a idade do banco e atribui ele ao objeto
				cliente.setTelefone(rset.getString("telefone_cli"));

				
				// Adiciono o contato recuperado, a lista de contatos
				clientes.add(cliente);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return clientes;
	}

	
	// EDITAR <=======
	public Cliente getContatoByCpf(String cpf) {

		String sql = "SELECT * FROM cliente where cpf_cli = ?";
		Cliente cliente = new Cliente();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpf);
			rset = pstm.executeQuery();

			rset.next();

			cliente.setNome(rset.getString("nome_cli"));
			cliente.setEmail(rset.getString("email_cli"));
	
			cliente.setTelefone(rset.getString("telefone_cli"));
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
  
    }
	
	
}
