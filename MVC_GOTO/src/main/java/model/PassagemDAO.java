package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import gotoviagens.Passagem;

public class PassagemDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Passagem passagem) {

		String sql = "INSERT INTO passagem(QUANTIDADE, ID_DESTINO)" + " VALUES(?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, passagem.getQuantidade());
			pstm.setInt(2, passagem.getIdDestino());
			
			pstm.execute();
			System.out.println("Passagem cadastrada com sucesso!");

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

		String sql = "DELETE FROM passagem WHERE ID_PASSAGEM = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
		
			pstm.execute();
			System.out.println("Passagem excluída com sucesso!");

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

	public void update(Passagem passagem) {
		
		String sql = "UPDATE passagem SET QUANTIDADE = ?, ID_DESTINO = ?"
		+ " WHERE ID_PASSAGEM = ?";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, passagem.getQuantidade());
			pstm.setInt(2, passagem.getIdDestino());
			

			pstm.setInt(3, passagem.getIdPassagem());
			
			pstm.execute();
			System.out.println("Passagem atualizada com sucesso!");

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
	

	public List<Passagem> getPassagens() {

		String sql = "SELECT * FROM passagem";

		List<Passagem> passagens = new ArrayList<Passagem>();


		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Passagem passagem = new Passagem();

				passagem.setQuantidade(rset.getInt("QUANTIDADE"));

				passagem.setIdDestino(rset.getInt("ID_DESTINO"));

				
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
			passagem.setIdDestino(rset.getInt("ID_DESTINO"));
	

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
