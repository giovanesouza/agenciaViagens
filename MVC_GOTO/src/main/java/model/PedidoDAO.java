package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import gotoviagens.Pedido;

public class PedidoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	
	public void save(Pedido pedido) {

		String sql = "INSERT INTO pedido(PRECOTOTAL, FORMA_PAG, MAT_FUNC, CPF_CLI,"
				+ " NOME_CLI, DATA_PEDIDO)" + " VALUES(?,?,?,?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setFloat(1, pedido.getPrecoTotal());
			pstm.setString(2, pedido.getPagamento());
			pstm.setInt(3, pedido.getMatFunc());
			pstm.setString(4, pedido.getCpfCli());
			pstm.setString(5, pedido.getNomeCli());
			
			pstm.setDate(6, new Date(pedido.getDataPedido().getTime()));

			pstm.execute();
			System.out.println("Pedido salvo com sucesso!");

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

		String sql = "DELETE FROM pedido WHERE NUM_PEDIDO = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
		
			pstm.execute();
			System.out.println("Pedido excluído com sucesso!");

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


	public void update(Pedido pedido) {
		
				
		String sql = "UPDATE pedido SET PRECOTOTAL = ?, FORMA_PAG = ? WHERE NUM_PEDIDO = ?";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setFloat(1, pedido.getPrecoTotal());
			pstm.setString(2, pedido.getPagamento());
			
			// CRIAR UMA NOVA COLUNA E INSERIR ESTE TRECHO COMO DATA 
			//pstm.setDate(3, new Date(pedido.getDataAtualizacao().getTime()));

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(3, pedido.getIdPedido());
			
			pstm.execute();
			System.out.println("Pedido atualizado com sucesso!");

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
	
	public List<Pedido> getPedidos() {

		String sql = "SELECT * FROM pedido";

		List<Pedido> pedidos = new ArrayList<Pedido>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Pedido pedido = new Pedido();

				pedido.setPrecoTotal(rset.getFloat("PRECOTOTAL"));

				pedido.setPagamento(rset.getString("FORMA_PAG"));

				pedido.setMatFunc(rset.getInt("MAT_FUNC"));
				
				pedido.setCpfCli(rset.getString("CPF_CLI"));
				
				pedido.setNomeCli(rset.getString("NOME_CLI"));
				
				pedido.setDataPedido(rset.getDate("DATA_PEDIDO"));
				
				
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
			pedido.setDataPedido(rset.getDate("DATA_PEDIDO"));
			

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
