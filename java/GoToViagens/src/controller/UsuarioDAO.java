package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gotoviagens.Usuario;

public class UsuarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Usuario usuario) {

		String sql = "INSERT INTO usuario(EMAIL_USUARIO, SENHA_USUARIO, DATACADASTRO,"
				+ " CPF_CLI, NOME_CLI)" + " VALUES(?,?,?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getEmailUsuario());
			pstm.setString(2, usuario.getSenha());
			pstm.setDate(3, new Date(usuario.getDataCadastro().getTime()));
			pstm.setString(4, usuario.getCpf());
			pstm.setString(5, usuario.getNome());
			
			pstm.execute();
			System.out.println("Usuário cadastrado com sucesso!");

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

		String sql = "DELETE FROM usuario WHERE ID_USUARIO = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
		
			pstm.execute();
			System.out.println("Usuário excluído com sucesso!");

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
		
		String sql = "UPDATE usuario SET EMAIL_USUARIO = ?, SENHA_USUARIO = ?, NOME_CLI = ?"
		+ " WHERE ID_USUARIO = ?";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getEmailUsuario());
			pstm.setString(2, usuario.getSenha());
			pstm.setString(3, usuario.getNome());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(4, usuario.getIdUsuario());
			
			pstm.execute();
			System.out.println("Usuário atualizado com sucesso!");

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

		String sql = "SELECT * FROM usuario";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();


			while (rset.next()) {

				Usuario usuario = new Usuario();

				usuario.setEmailUsuario(rset.getString("EMAIL_USUARIO"));

				usuario.setSenha(rset.getString("SENHA_USUARIO"));

				usuario.setDataCadastro(rset.getDate("DATACADASTRO"));
				
				usuario.setCpf(rset.getString("CPF_CLI"));
				
				usuario.setNome(rset.getString("NOME_CLI"));
				
				
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

	
	public Usuario getClienteById(int id) {

		String sql = "SELECT * FROM usuario where ID_USUARIO = ?";
		Usuario usuario = new Usuario();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			usuario.setEmailUsuario(rset.getString("EMAIL_USUARIO"));
			usuario.setSenha(rset.getString("SENHA_USUARIO"));
			
			usuario.setDataCadastro(rset.getDate("DATACADASTRO"));
	
			usuario.setCpf(rset.getString("CPF_CLI"));
			usuario.setNome(rset.getString("NOME_CLI"));
			

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
