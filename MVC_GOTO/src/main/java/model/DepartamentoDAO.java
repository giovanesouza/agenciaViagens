package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DepartamentoDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Departamento departamento) {

		String sql = "INSERT INTO departamento(NOME_DEPARTAMENTO, COD_UNID)"
		+ " VALUES(?,?)";

		try {
			// 
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, departamento.getNomeDepartamento());
			pstm.setInt(2, departamento.getCodUnid());	
			
			pstm.execute();
			
			System.out.println("Departamento cadastrado com sucesso!");

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

	public void removeByCod(int codDep) {

		String sql = "DELETE FROM departamento WHERE COD_DEPARTAMENTO = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, codDep); 

			pstm.execute();
			
			System.out.println("Departamento excluído com sucesso!");

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

	public void update(Departamento departamento) {
		
		String sql = "UPDATE departamento SET NOME_DEPARTAMENTO = ?, COD_UNID = ?"
		+ " WHERE COD_DEPARTAMENTO = ?";

		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, departamento.getNomeDepartamento());
			pstm.setInt(2, departamento.getCodUnid());

			pstm.setInt(3, departamento.getCodDepartamento());
			
			pstm.execute();
			
			System.out.println("Departamento atualizado com sucesso!");

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
	
	public List<Departamento> getDepartamento() {

		String sql = "SELECT * FROM departamento";

		List<Departamento> departamentos = new ArrayList<Departamento>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

	
			while (rset.next()) {

				Departamento departamento = new Departamento();

				departamento.setCodDepartamento(rset.getInt("COD_DEPARTAMENTO"));
				departamento.setNomeDepartamento(rset.getString("NOME_DEPARTAMENTO"));
				
				departamento.setCodUnid(rset.getInt("COD_UNID"));
				
				departamentos.add(departamento);
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

		return departamentos;
	}

	
	public Departamento getDepartamentoByCod(int codDep) {

		String sql = "SELECT * FROM departamento where COD_DEPARTAMENTO = ?";
		Departamento departamento = new Departamento();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codDep);
			rset = pstm.executeQuery();

			rset.next();

			departamento.setNomeDepartamento(rset.getString("NOME_DEPARTAMENTO"));
			departamento.setCodUnid(rset.getInt("COD_UNID"));
	
						

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
		return departamento;
	
	
	}

}
