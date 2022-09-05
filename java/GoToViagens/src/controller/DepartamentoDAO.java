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
		String sql = "INSERT INTO departamento(Cod_Departamento,Nome_Departamento, Cod_Unid)"
		+ " VALUES(?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// EDITAR <=======
			pstm.setInt(1, departamento.getCodDepartamento());
			pstm.setString(2, departamento.getNomeDepartamento());
			pstm.setInt(3, departamento.getCodUnid());
			
			
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
	public void removeByCod(int cod) {

		String sql = "DELETE FROM departamento WHERE Cod_Departamento = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, cod); // TROQUEI STRING PARA LONG

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
		
		String sql = "UPDATE cliente SET Cod_Departamento = ?, Nome_Departamento = ?, Cod_Unid = ?"
		+ " WHERE Cod_Departamento = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// EDITAR <=======
			pstm.setInt(1, departamento.getCodDepartamento());
			pstm.setString(2, departamento.getNomeDepartamento());
			pstm.setInt(3, departamento.getCodUnid());


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
				departamento.setCodDepartamento(rset.getInt("Cod_Departamento"));

				// Recupera o nome do banco e atribui ele ao objeto
				departamento.setNomeDepartamento(rset.getString("Nome_Departamento"));

				// Recupera a idade do banco e atribui ele ao objeto
				departamento.setCodUnid(rset.getInt("Cod_Unid"));
				
				
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
	public Departamento getContatoByCod(int cod) {

		String sql = "SELECT * FROM departamento where Cod_Departamento = ?";
		Departamento departamento = new Departamento();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rset = pstm.executeQuery();

			rset.next();

			departamento.setCodDepartamento(rset.getInt("Cod_Departamento"));
			departamento.setNomeDepartamento(rset.getString("Nome_Departamento"));
	
			departamento.setCodUnid(rset.getInt("Cod_Unidade"));
			

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
