package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gotoviagens.Departamento;

public class DepartamentoDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// EDITAR <=======
	public void save(Departamento departamento) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		// EDITAR <=======
		String sql = "INSERT INTO departamento(NOME_DEPARTAMENTO, COD_UNID)"
		+ " VALUES(?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// EDITAR <=======
			pstm.setString(1, departamento.getNomeDepartamento());
			pstm.setInt(2, departamento.getCodUnid());	
			
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
	public void removeByCod(int codDep) {

		String sql = "DELETE FROM departamento WHERE COD_DEPARTAMENTO = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, codDep); // TROQUEI STRING PARA LONG

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
	public void update(Departamento departamento) {
		
		String sql = "UPDATE departamento SET NOME_DEPARTAMENTO = ?, COD_UNID = ?"
		+ " WHERE COD_DEPARTAMENTO = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// EDITAR <=======
			pstm.setString(1, departamento.getNomeDepartamento());
			pstm.setInt(2, departamento.getCodUnid());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(3, departamento.getCodDepartamento());
			
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
	public List<Departamento> getDepartamento() {

		String sql = "SELECT * FROM departamento";

		List<Departamento> departamentos = new ArrayList<Departamento>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Departamento departamento = new Departamento();

				// Recupera o id do banco e atribui ele ao objeto
				departamento.setCodDepartamento(rset.getInt("COD_DEPARTAMENTO"));

				// Recupera o nome do banco e atribui ele ao objeto
				departamento.setNomeDepartamento(rset.getString("NOME_DEPARTAMENTO"));

				// Recupera a idade do banco e atribui ele ao objeto
				departamento.setCodUnid(rset.getInt("COD_UNID"));
				
				
				// Adiciono o contato recuperado, a lista de contatos
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

	
	// EDITAR <=======
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
