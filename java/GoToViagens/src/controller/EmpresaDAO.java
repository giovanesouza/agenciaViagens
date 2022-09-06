package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gotoviagens.Empresa;

public class EmpresaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	
	public void save(Empresa empresa) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados


		String sql = "INSERT INTO EMPRESA (UNIDADE, TELEFONE, EMAIL, ENDERECO)"
		+ " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// ======= SET TIPO + GET DA CLASSE SEM O DAO
			pstm.setString(1, empresa.getUnidade());
			pstm.setString(2, empresa.getTelefone());
			pstm.setString(3, empresa.getEmail());
			pstm.setString(4, empresa.getEndereco());
			
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


	public void removeByCodUnid(int codUnid) {

		String sql = "DELETE FROM empresa WHERE COD_UNID = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, codUnid);

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


	public void update(Empresa empresa) {
		
		String sql = "UPDATE empresa SET UNIDADE = ?, TELEFONE = ?, EMAIL = ?, ENDERECO = ?"
		+ " WHERE COD_UNID = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, empresa.getUnidade());
			pstm.setString(2, empresa.getTelefone());
			pstm.setString(3, empresa.getEmail());
			pstm.setString(4, empresa.getEndereco());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(5, empresa.getCodUnid());
			
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
	

	public List<Empresa> getEmpresas() {

		String sql = "SELECT * FROM empresa";

		List<Empresa> empresas = new ArrayList<Empresa>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Empresa empresa = new Empresa();

				pstm.setString(1, empresa.getUnidade());
				pstm.setString(2, empresa.getTelefone());
				pstm.setString(3, empresa.getEmail());
				pstm.setString(4, empresa.getEndereco());

				
				// Adiciono o contato recuperado, a lista de contatos
				empresas.add(empresa);
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

		return empresas;
	}

	
	// EDITAR <=======
	public Empresa getUnidadesByCod(int codUnid) {

		String sql = "SELECT * FROM empresa where COD_UNID = ?";
		Empresa empresa = new Empresa();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codUnid);
			rset = pstm.executeQuery();

			rset.next();

			empresa.setUnidade(rset.getString("UNIDADE"));
			empresa.setTelefone(rset.getString("TELEFONE"));
			empresa.setEmail(rset.getString("EMAIL"));
			empresa.setEndereco(rset.getString("ENDERECO"));
			

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
		return empresa;
  
    }
	
	
	
}
