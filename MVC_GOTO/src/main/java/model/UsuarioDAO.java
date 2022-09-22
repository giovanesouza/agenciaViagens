package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


//import gotoviagens.Usuario;

public class UsuarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Usuario usuario) {

		String sql = "INSERT INTO USUARIO(NOME, CPF, EMAIL, SENHA, DATACADASTRO) VALUES(?,?,?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getCpf());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getSenha());
			pstm.setDate(5, new Date(usuario.getDataCadastro().getTime()));

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

	public void removeById(int id) {

		String sql = "DELETE FROM USUARIO WHERE ID = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

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

	public void update(Usuario usuario) {

		String sql = "UPDATE USUARIO SET NOME = ?, TELEFONE = ?, EMAIL = ?, SENHA = ?, DATAATUALIZACAOCADASTRO = ? WHERE ID = ?";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getTelefone());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getSenha());
			
			pstm.setDate(5, new Date(usuario.getDataAtualizacaoCadastro().getTime()));

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(6, usuario.getId());

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

	public List<Usuario> getUsuarios() {

		String sql = "SELECT * FROM USUARIO";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Usuario usuario = new Usuario();

				usuario.setCpf(rset.getString("CPF"));
				usuario.setNome(rset.getString("NOME"));
				usuario.setTelefone(rset.getString("TELEFONE"));
				usuario.setEmail(rset.getString("EMAIL"));
				usuario.setSenha(rset.getString("SENHA"));
				usuario.setDataCadastro(rset.getDate("DATACADASTRO"));
				usuario.setDataAtualizacaoCadastro(rset.getDate("DATAATUALIZACAOCADASTRO"));

				usuarios.add(usuario);
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

		return usuarios;
	}

	// CÓDIGO NOVO

	public Usuario buscarUsuarioPorEmail(String email) {

		String sql = "SELECT * FROM USUARIO WHERE EMAIL = ?";

		Usuario usuario = new Usuario();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, email);
			rset = pstm.executeQuery();

			rset.next();

			usuario.setId(rset.getInt("ID"));
			usuario.setCpf(rset.getString("CPF"));
			usuario.setNome(rset.getString("NOME"));
			usuario.setTelefone(rset.getString("TELEFONE"));
			usuario.setSenha(rset.getString("SENHA"));
			usuario.setDataCadastro(rset.getDate("DATACADASTRO"));
			usuario.setDataAtualizacaoCadastro(rset.getDate("DATAATUALIZACAOCADASTRO"));
			
			
			// CÓDIGO ADD PARA FUNCIONAR A ATUALIZAÇÃO
			usuario.setEmail(rset.getString("EMAIL"));

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
		return usuario;

	}
	

	// FIM CÓDIGO NOVO

	
	public Usuario getUsuarioById(int id) {

		String sql = "SELECT * FROM USUARIO where ID = ?";
		Usuario usuario = new Usuario();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			usuario.setCpf(rset.getString("CPF"));
			usuario.setNome(rset.getString("NOME"));
			usuario.setTelefone(rset.getString("TELEFONE"));
			usuario.setEmail(rset.getString("EMAIL"));
			usuario.setSenha(rset.getString("SENHA"));
			usuario.setDataCadastro(rset.getDate("DATACADASTRO"));
			usuario.setDataAtualizacaoCadastro(rset.getDate("DATAATUALIZACAOCADASTRO"));

			// CÓDIGO ADD PARA FUNCIONAR A ATUALIZAÇÃO
			usuario.setId(rset.getInt("ID"));

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
		return usuario;

	}

}
