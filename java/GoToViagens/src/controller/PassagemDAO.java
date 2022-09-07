package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gotoviagens.Passagem;

public class PassagemDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// EDITAR <=======
	public void save(Passagem passagem) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		// EDITAR <=======
		String sql = "INSERT INTO passagem(QUANTIDADE, ID_DESTINO)" + " VALUES(?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// EDITAR <======= SET TIPO + GET DA CLASSE SEM O DAO
			pstm.setInt(1, passagem.getQuantidade());
			pstm.setInt(2, passagem.getIdDestino());
			
			
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

		String sql = "DELETE FROM passagem WHERE ID_PASSAGEM = ?";

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
	public void update(Passagem passagem) {
		
		String sql = "UPDATE passgem SET QUANTIDADE = ?, ID_DESTINO = ?"
		+ " WHERE ID_PASSAGEM = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// EDITAR <=======
			pstm.setInt(1, passagem.getQuantidade());
			pstm.setInt(2, passagem.getIdDestino());
			

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(3, passagem.getIdPassagem());
			
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
	public List<Passagem> getPassagens() {

		String sql = "SELECT * FROM passagem";

		List<Passagem> passagens = new ArrayList<Passagem>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Passagem passagem = new Passagem();

				// Recupera o id do banco e atribui ele ao objeto
				passagem.setQuantidade(rset.getInt("QUANTIDADE"));

				// Recupera o nome do banco e atribui ele ao objeto
				passagem.setIdDestino(rset.getInt("ID_DESTINO"));

				
				// Adiciono o contato recuperado, a lista de contatos
				passagens.add(passagem);
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

		return passagens;
	}

	
	// EDITAR <=======
	public Passagem getPassagemById(int id) {

		String sql = "SELECT * FROM passagem where ID_PASSAGEM = ?";
		Passagem passagem = new Passagem();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			passagem.setQuantidade(rset.getInt("QUANTIDADE"));
			passagem.setIdPassagem(rset.getInt("ID_DESTINO"));
	

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
		return passagem;
  
    }


}
