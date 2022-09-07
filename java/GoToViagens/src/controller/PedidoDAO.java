package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gotoviagens.Pedido;

public class PedidoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// EDITAR <=======
	
	public void save(Pedido pedido) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		// EDITAR <=======
		String sql = "INSERT INTO pedido(PRECOTOTAL, FORMA_PAG, MAT_FUNC, CPF_CLI,"
				+ " NOME_CLI, DATA_PEDIDO)" + " VALUES(?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// EDITAR <======= SET TIPO + GET DA CLASSE SEM O DAO
			pstm.setFloat(1, pedido.getPrecoTotal());
			pstm.setString(2, pedido.getPagamento());
			pstm.setInt(3, pedido.getMatFunc());
			pstm.setString(4, pedido.getCpfCli());
			pstm.setString(5, pedido.getNomeCli());
			
			pstm.setDate(6, new Date(pedido.getDataPedido().getTime()));

			
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
	public void removeById(int id) {

		String sql = "DELETE FROM pedido WHERE NUM_PEDIDO = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// TIPO DE VALOR REFERENTE AO CPF E 1 = QTD QUE SERÁ EXCLUÍDA
			pstm.setInt(1, id);
		
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
	public void update(Pedido pedido) {
		
		String sql = "UPDATE pedido SET PRECOTOTAL = ?, FORMA_PAG = ?, MAT_FUNC = ?, CPF_CLI = ?"
				+ "NOME_CLI = ?"
		+ " WHERE NUM_PEDIDO = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// EDITAR <=======
			pstm.setFloat(1, pedido.getPrecoTotal());
			pstm.setString(2, pedido.getPagamento());
			pstm.setInt(3, pedido.getMatFunc());
			pstm.setString(4, pedido.getCpfCli());
			pstm.setString(5, pedido.getNomeCli());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(6, pedido.getIdPedido());
			
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
	public List<Pedido> getPedidos() {

		String sql = "SELECT * FROM pedido";

		List<Pedido> pedidos = new ArrayList<Pedido>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Pedido pedido = new Pedido();

				// Recupera o id do banco e atribui ele ao objeto
				pedido.setPrecoTotal(rset.getFloat("PRECOTOTAL"));

				// Recupera o nome do banco e atribui ele ao objeto
				pedido.setPagamento(rset.getString("FORMA_PAG"));

				// Recupera a idade do banco e atribui ele ao objeto
				pedido.setMatFunc(rset.getInt("MAT_FUNC"));
				
				// Recupera a idade do banco e atribui ele ao objeto
				pedido.setCpfCli(rset.getString("CPF_CLI"));
				
				pedido.setNomeCli(rset.getString("NOME_CLI"));

				
				// Adiciono o contato recuperado, a lista de contatos
				pedidos.add(pedido);
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

		return pedidos;
	}

	
	// EDITAR <=======
	public Pedido getPedidoById(int id) {

		String sql = "SELECT * FROM pedido where NUM_PEDIDO = ?";
		Pedido pedido = new Pedido();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			pedido.setPrecoTotal(rset.getFloat("PRECOTOTAL"));
			pedido.setPagamento(rset.getString("FORMA_PAG"));
	
			pedido.setMatFunc(rset.getInt("MAT_FUNC"));
			pedido.setCpfCli(rset.getString("CPF_CLI"));
			pedido.setNomeCli(rset.getString("NOME_CLI"));
			

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
		return pedido;
  
    }

	
}
