package br.com.gotoviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gotoviagens.model.Usuario;

// RESPONSÁVEL EM FAZER OS COMANDOS DO CRUD (CREATE, READ, UPDATE E DELETE). FAZ A FUNÇÃO DO DAO
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// MÉTODO PAVA VALIDAÇÃO DE USUÁRIO
	// VAI NO BANCO DE DADOS, FAZ O SELECT PASSANDO O E-MAIL E SENHA. SE ENCONTRAR
	// O USUÁRIO NO BANCO, ELE VOLTA COM OS DADOS NA FORMA DE OBJETO INSTANCIADO.
	
	@Query(value="select * from usuario where email = :email and senha = :senha", nativeQuery = true)
	public Usuario Login(String email, String senha);
	
	
	// LISTA DOS CPFs CADASTRADOS
	@Query(value="select * from usuario where cpf = :cpf", nativeQuery = true)
	public Usuario findByCpf(String cpf);

	
	// UTILIZADO PARA ALTERAÇÃO DE SENHA SEM ESTAR LOGADO
	@Query(value="select * from usuario where email = :email and cpf = :cpf", nativeQuery = true)
	public Usuario findByEmailCpf(String email, String cpf);
	
}
