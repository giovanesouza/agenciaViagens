package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gotoviagens.Funcionario;

public class FuncionarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// EDITAR <=======
	public void save(Funcionario funcionario) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		// EDITAR <=======
		String sql = "INSERT INTO funcionario(NOME_FUNC, CARGO_FUNC, SALARIO_FUNC, COD_DEPARTAMENTO)"
		+ " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// EDITAR <======= SET TIPO + GET DA CLASSE SEM O DAO
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCargo());
			pstm.setFloat(3, funcionario.getSalario());
			pstm.setInt(4, funcionario.getCodDepartamento());
			
			
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
	public void removeByMat(int mat) {

		String sql = "DELETE FROM funcionario WHERE MAT_FUNC = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// TIPO DE VALOR REFERENTE AO CPF E 1 = QTD QUE SERÁ EXCLUÍDA
			pstm.setInt(1, mat);
		
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
	public void update(Funcionario funcionario) {
		
		String sql = "UPDATE funcionario SET NOME_FUNC = ?, CARGO_FUNC = ?,"
				+ "SALARIO_FUNC = ?, COD_DEPARTAMENTO" + " WHERE MAT_FUNC = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// EDITAR <=======
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCargo());
			pstm.setFloat(3, funcionario.getSalario());
			pstm.setInt(4, funcionario.getCodDepartamento());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(5, funcionario.getMatricula());
			
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
	public List<Funcionario> getFuncionarios() {

		String sql = "SELECT * FROM funcionario";

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Funcionario funcionario = new Funcionario();

				
				// Recupera o nome do banco e atribui ele ao objeto
				funcionario.setNome(rset.getString("NOME_FUNC"));

				// Recupera a idade do banco e atribui ele ao objeto
				funcionario.setCargo(rset.getString("CARGO_FUNC"));
				
				// Recupera a idade do banco e atribui ele ao objeto
				funcionario.setSalario(rset.getFloat("SALARIO_FUNC"));

				// Recupera a idade do banco e atribui ele ao objeto
				funcionario.setCodDepartamento(rset.getInt("COD_DEPARTAMENTO"));

				
				// Adiciono o contato recuperado, a lista de contatos
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

	
	// EDITAR <=======
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
