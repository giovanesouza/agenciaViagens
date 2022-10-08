package br.com.gotoviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gotoviagens.model.Usuario;

// RESPONSÁVEL EM FAZER OS COMANDOS DO CRUD (CREATE, READ, UPDATE E DELETE). FAZ A FUNÇÃO DO DAO
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
