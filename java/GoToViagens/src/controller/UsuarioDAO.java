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

	// EDITAR <=======
	public void save(Usuario usuario) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		// EDITAR <=======
		String sql = "INSERT INTO usuario(EMAIL_USUARIO, SENHA_USUARIO, DATACADASTRO,"
				+ " CPF_CLI, NOME_CLI)" + " VALUES(?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// EDITAR <======= SET TIPO + GET DA CLASSE SEM O DAO
			pstm.setString(1, usuario.getEmailUsuario());
			pstm.setString(2, usuario.getSenha());
			pstm.setDate(3, new Date(usuario.getDataCadastro().getTime()));
			pstm.setString(4, usuario.getCpf());
			pstm.setString(5, usuario.getNome());
			
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
	public void removeById(int id) {

		String sql = "DELETE FROM usuario WHERE ID_USUARIO = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// TIPO DE VALOR REFERENTE AO CPF E 1 = QTD QUE SERÁ EXCLUÍDA
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

	// EDITAR <=======
	public void update(Usuario usuario) {
		
		String sql = "UPDATE usuario SET EMAIL_USUARIO = ?, SENHA_USUARIO = ?, NOME_CLI = ?"
		+ " WHERE ID_USUARIO = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// EDITAR <=======
			pstm.setString(1, usuario.getEmailUsuario());
			pstm.setString(2, usuario.getSenha());
			pstm.setString(3, usuario.getNome());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(4, usuario.getIdUsuario());
			
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
	public List<Usuario> getUsuarios() {

		String sql = "SELECT * FROM usuario";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Usuario usuario = new Usuario();

				// Recupera o id do banco e atribui ele ao objeto
				usuario.setEmailUsuario(rset.getString("EMAIL_USUARIO"));

				// Recupera o nome do banco e atribui ele ao objeto
				usuario.setSenha(rset.getString("SENHA_USUARIO"));

				// Recupera a idade do banco e atribui ele ao objeto
				usuario.setDataCadastro(rset.getDate("DATACADASTRO"));
				
				// Recupera a idade do banco e atribui ele ao objeto
				usuario.setCpf(rset.getString("CPF_CLI"));
				
				usuario.setNome(rset.getString("NOME_CLI"));
				
				// Adiciono o contato recuperado, a lista de contatos
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

	
	// EDITAR <=======
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
