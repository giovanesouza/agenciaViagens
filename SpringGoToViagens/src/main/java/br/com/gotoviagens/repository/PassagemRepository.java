package br.com.gotoviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gotoviagens.model.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {

	
	
}
