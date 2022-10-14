package br.com.gotoviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gotoviagens.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
