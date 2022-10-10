package br.com.gotoviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gotoviagens.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
