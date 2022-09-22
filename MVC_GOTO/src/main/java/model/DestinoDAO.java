package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DestinoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;


	public void save(Destino destino) {


		String sql = "INSERT INTO destino(NOME_DESTINO, PRECO_DESTINO, CATEGORIA_DESTINO,"
				+ " QTD_DISPONIVEL, CONDICAO)" + " VALUES(?,?,?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getNomeDestino());
			pstm.setFloat(2, destino.getPrecoUnit());
			pstm.setString(3, destino.getCategoriaDestino());
			pstm.setInt(4, destino.getQtdDisponivel());
			pstm.setString(5, destino.getCondicao());
			
			pstm.execute();
			System.out.println("Destino adicionado com sucesso!");

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

	public void removeById(int id) {

		String sql = "DELETE FROM destino WHERE ID_DESTINO = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
		
			pstm.execute();
			System.out.println("Destino excluído com sucesso!");

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


	public void update(Destino destino) {
		
		String sql = "UPDATE destino SET NOME_DESTINO = ?, PRECO_DESTINO = ?,"
				+ " CATEGORIA_DESTINO = ?, QTD_DISPONIVEL = ?, CONDICAO = ?"
		+ " WHERE ID_DESTINO = ?";

		try {

			conn = Conexao.createConnectionToMySQL();


			pstm = conn.prepareStatement(sql);
			

			pstm.setString(1, destino.getNomeDestino());
			pstm.setFloat(2, destino.getPrecoUnit());
			pstm.setString(3, destino.getCategoriaDestino());
			pstm.setInt(4, destino.getQtdDisponivel());
			pstm.setString(5, destino.getCondicao());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(6, destino.getIdDestino());
			

			pstm.execute();
			System.out.println("Destino atualizado com sucesso!");

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
	

	public List<Destino> getDestinos() {

		String sql = "SELECT * FROM destino";

		List<Destino> destinos = new ArrayList<Destino>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();


			while (rset.next()) {

				Destino destino = new Destino();


				destino.setNomeDestino(rset.getString("NOME_DESTINO"));

				destino.setPrecoUnit(rset.getFloat("PRECO_DESTINO"));

				destino.setCategoriaDestino(rset.getString("CATEGORIA_DESTINO"));
				
				destino.setQtdDisponivel(rset.getInt("QTD_DISPONIVEL"));
				
				destino.setCondicao(rset.getString("CONDICAO"));

				
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
