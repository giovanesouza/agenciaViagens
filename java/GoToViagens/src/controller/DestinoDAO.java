package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gotoviagens.Destino;

public class DestinoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// EDITAR <=======
	public void save(Destino destino) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		// EDITAR <=======
		String sql = "INSERT INTO destino(NOME_DESTINO, PRECO_DESTINO, CATEGORIA_DESTINO,"
				+ " QTD_DISPONIVEL, CONDICAO)" + " VALUES(?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// EDITAR <======= SET TIPO + GET DA CLASSE SEM O DAO
			pstm.setString(1, destino.getNomeDestino());
			pstm.setFloat(2, destino.getPrecoUnit());
			pstm.setString(3, destino.getCategoriaDestino());
			pstm.setInt(4, destino.getQtdDisponivel());
			pstm.setString(5, destino.getCondicao());
			
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

		String sql = "DELETE FROM destino WHERE ID_DESTINO = ?";

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
	public void update(Destino destino) {
		
		String sql = "UPDATE destino SET NOME_DESTINO = ?, PRECO_DESTINO = ?,"
				+ " CATEGORIA_DESTINO = ?, QTD_DISPONÍVEL = ?, CONDICAO = ?"
		+ " WHERE ID_DESTINO = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// EDITAR <=======
			pstm.setString(1, destino.getNomeDestino());
			pstm.setFloat(2, destino.getPrecoUnit());
			pstm.setString(3, destino.getCategoriaDestino());
			pstm.setInt(4, destino.getQtdDisponivel());
			pstm.setString(5, destino.getCondicao());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(6, destino.getIdDestino());
			
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
	public List<Destino> getDestinos() {

		String sql = "SELECT * FROM destino";

		List<Destino> destinos = new ArrayList<Destino>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Destino destino = new Destino();

				// Recupera o id do banco e atribui ele ao objeto
				destino.setNomeDestino(rset.getString("NOME_DESTINO"));

				// Recupera o nome do banco e atribui ele ao objeto
				destino.setPrecoUnit(rset.getFloat("PRECO_DESTINO"));

				// Recupera a idade do banco e atribui ele ao objeto
				destino.setCategoriaDestino(rset.getString("CATEGORIA_DESTINO"));
				
				// Recupera a idade do banco e atribui ele ao objeto
				destino.setQtdDisponivel(rset.getInt("QTD_DESTINO"));
				
				destino.setCondicao(rset.getString("CONDICAO"));

				
				// Adiciono o contato recuperado, a lista de contatos
				destinos.add(destino);
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

		return destinos;
	}

	
	// EDITAR <=======
	public Destino getDestinoById(int id) {

		String sql = "SELECT * FROM destino where ID_DESTINO = ?";
		Destino destino = new Destino();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			destino.setNomeDestino(rset.getString("NOME_DESTINO"));
			destino.setPrecoUnit(rset.getFloat("PRECO_DESTINO"));
			destino.setCategoriaDestino(rset.getString("CATEGORIA_DESTINO"));
			destino.setQtdDisponivel(rset.getInt("QTD_DISPONIVEL"));
			destino.setCondicao(rset.getString("CONDICAO"));
			

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
		return destino;
  
    }

	
}
