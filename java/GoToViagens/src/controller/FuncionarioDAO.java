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
		String sql = "INSERT INTO funcionario(mat_func,nome_func,cargo_func,salario_func,cod_departamento)" + " VALUES(?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// EDITAR <======= SET TIPO + GET DA CLASSE SEM O DAO
			pstm.setInt(1, funcionario.getMatricula());
			pstm.setString(2, funcionario.getNome());
			pstm.setString(3, funcionario.getCargo());
			pstm.setFloat(4, funcionario.getSalario());
			pstm.setInt(5, funcionario.getCodDepartamento());
			
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

		String sql = "DELETE FROM funcionario WHERE mat_func = ?";

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
		
		String sql = "UPDATE funcionario SET cargo_func = ?, salario_func = ?, cod_departamento = ?"
		+ " WHERE mat_func = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// EDITAR <=======
			pstm.setString(1, funcionario.getCargo());
			pstm.setFloat(2, funcionario.getSalario());
			pstm.setInt(3, funcionario.getCodDepartamento());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(4, funcionario.getMatricula());
			
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
				funcionario.setNome(rset.getString("nome_func"));

				// Recupera a idade do banco e atribui ele ao objeto
				funcionario.setCargo(rset.getString("cargo_func"));
				
				// Recupera a idade do banco e atribui ele ao objeto
				funcionario.setSalario(rset.getFloat("salario_func"));

				// Recupera a idade do banco e atribui ele ao objeto
				funcionario.setCodDepartamento(rset.getInt("cod_departamento"));

				
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

		String sql = "SELECT * FROM funcionario where mat_func = ?";
		Funcionario funcionario = new Funcionario();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, mat);
			rset = pstm.executeQuery();

			rset.next();

			funcionario.setNome(rset.getString("nome_func"));
			funcionario.setCargo(rset.getString("cargo_func"));
			funcionario.setSalario(rset.getFloat("salario_func"));
	
			funcionario.setCodDepartamento(rset.getInt("cod_departamento"));
			

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
