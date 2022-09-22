package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpresaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	
	public void save(Empresa empresa) {


		String sql = "INSERT INTO EMPRESA (UNIDADE, TELEFONE, EMAIL, ENDERECO)"
		+ " VALUES(?,?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, empresa.getUnidade());
			pstm.setString(2, empresa.getTelefone());
			pstm.setString(3, empresa.getEmail());
			pstm.setString(4, empresa.getEndereco());
			
			pstm.execute();
			System.out.println("Unidade cadastrada com sucesso!");

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


	public void removeByCodUnid(int codUnid) {

		String sql = "DELETE FROM empresa WHERE COD_UNID = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, codUnid);

			pstm.execute();
			System.out.println("Unidade excluída com sucesso!");

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
			
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, empresa.getUnidade());
			pstm.setString(2, empresa.getTelefone());
			pstm.setString(3, empresa.getEmail());
			pstm.setString(4, empresa.getEndereco());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(5, empresa.getCodUnid());
			
			pstm.execute();
			System.out.println("Unidade atualizada com sucesso!");

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
	

	public List<Empresa> getEmpresas() {

		String sql = "SELECT * FROM empresa";

		List<Empresa> empresas = new ArrayList<Empresa>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			
			while (rset.next()) {

				Empresa empresa = new Empresa();

				empresa.setCodUnid(rset.getInt("COD_UNID"));
				empresa.setUnidade(rset.getString("UNIDADE"));
				empresa.setTelefone(rset.getString("TELEFONE"));
				empresa.setEmail(rset.getString("EMAIL"));
				empresa.setEndereco(rset.getString("ENDERECO"));

				//pstm.setInt(1, empresa.getCodUnid());
				//pstm.setString(2, empresa.getUnidade());
				//pstm.setString(3, empresa.getTelefone());
				//pstm.setString(4, empresa.getEmail());
				//pstm.setString(5, empresa.getEndereco());

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
