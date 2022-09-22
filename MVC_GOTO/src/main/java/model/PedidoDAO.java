package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PedidoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	
	public void save(Pedido pedido) {

		String sql = "INSERT INTO pedido(DATA_PEDIDO, MAT_FUNC, IDUSUARIO, PRECOTOTAL,"
				+ "FORMA_PAG) VALUES(?,?,?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setDate(1, new Date(pedido.getDataPedido().getTime()));
			pstm.setInt(2, pedido.getMatFunc());
			pstm.setInt(3, pedido.getIdUsuario());
			pstm.setFloat(4, pedido.getPrecoTotal());
			pstm.setString(5, pedido.getPagamento());

			//pstm.setInt(3, pedido.getMatFunc());

			

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
		
				
		String sql = "UPDATE pedido SET PRECOTOTAL = ?, FORMA_PAG = ?, STATUSPEDIDO = ? WHERE NUM_PEDIDO = ?";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setFloat(1, pedido.getPrecoTotal());
			pstm.setString(2, pedido.getPagamento());
			pstm.setString(3, pedido.getStatusPedido());
			
			// CRIAR UMA NOVA COLUNA E INSERIR ESTE TRECHO COMO DATA 
			//pstm.setDate(3, new Date(pedido.getDataAtualizacao().getTime()));

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(4, pedido.getIdPedido());
			
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

				pedido.setIdPedido(rset.getInt("NUM_PEDIDO"));
				pedido.setDataPedido(rset.getDate("DATA_PEDIDO"));
				pedido.setPrecoTotal(rset.getFloat("PRECOTOTAL"));
				pedido.setIdUsuario(rset.getInt("IDUSUARIO"));
				pedido.setMatFunc(rset.getInt("MAT_FUNC"));
				
				pedido.setPagamento(rset.getString("FORMA_PAG"));

				pedido.setStatusPedido(rset.getString("STATUSPEDIDO"));
				
				
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

			
			pedido.setIdPedido(rset.getInt("NUM_PEDIDO"));
			pedido.setDataPedido(rset.getDate("DATA_PEDIDO"));
			pedido.setPrecoTotal(rset.getFloat("PRECOTOTAL"));
			pedido.setIdUsuario(rset.getInt("IDUSUARIO"));
			
			pedido.setPagamento(rset.getString("FORMA_PAG"));

			pedido.setStatusPedido(rset.getString("STATUSPEDIDO"));
				

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
