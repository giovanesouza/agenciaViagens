package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Funcionario funcionario) {

		String sql = "INSERT INTO funcionario(NOME_FUNC, CARGO_FUNC, SALARIO_FUNC, COD_DEPARTAMENTO)"
		+ " VALUES(?,?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCargo());
			pstm.setFloat(3, funcionario.getSalario());
			pstm.setInt(4, funcionario.getCodDepartamento());
			
			pstm.execute();
			System.out.println("Funcionário cadastrado com sucesso!");

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

	public void removeByMat(int mat) {

		String sql = "DELETE FROM funcionario WHERE MAT_FUNC = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, mat);
		
			pstm.execute();
			System.out.println("Funcionário excluído com sucesso!");

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

	public void update(Funcionario funcionario) {
		
		String sql = "UPDATE funcionario SET CARGO_FUNC = ?, SALARIO_FUNC = ?,"
				+ "COD_DEPARTAMENTO = ? WHERE MAT_FUNC = ?";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, funcionario.getCargo());
			pstm.setFloat(2, funcionario.getSalario());
			pstm.setInt(3, funcionario.getCodDepartamento());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(4, funcionario.getMatricula());
			
			pstm.execute();
			System.out.println("Funcionário atualizado com sucesso!");

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
	
	public List<Funcionario> getFuncionarios() {

		String sql = "SELECT * FROM funcionario";

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Funcionario funcionario = new Funcionario();

				
				funcionario.setNome(rset.getString("NOME_FUNC"));

				funcionario.setCargo(rset.getString("CARGO_FUNC"));
				
				funcionario.setSalario(rset.getFloat("SALARIO_FUNC"));

				funcionario.setCodDepartamento(rset.getInt("COD_DEPARTAMENTO"));

								
				funcionarios.add(funcionario);
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

		return funcionarios;
	}

	
	public Funcionario getFuncionariosByMat(int mat) {

		String sql = "SELECT * FROM funcionario where MAT_FUNC = ?";
		
		Funcionario funcionario = new Funcionario();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, mat);
			rset = pstm.executeQuery();

			rset.next();

			funcionario.setNome(rset.getString("NOME_FUNC"));
			funcionario.setCargo(rset.getString("CARGO_FUNC"));
			funcionario.setSalario(rset.getFloat("sALARIO_FUNC"));
	
			funcionario.setCodDepartamento(rset.getInt("COD_DEPARTAMENTO"));
			

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
		return funcionario;
  
    }

	
	
}
