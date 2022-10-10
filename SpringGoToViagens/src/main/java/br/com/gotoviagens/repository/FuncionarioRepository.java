package br.com.gotoviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gotoviagens.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
