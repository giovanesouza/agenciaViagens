package br.com.gotoviagens.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gotoviagens.model.Destinos;

public interface DestinosRepository extends JpaRepository<Destinos, Long> {

	/*
	 * @Query(value="select * from destinos where embarque = :embarque" +
	 * ", destino = :destino and dataIda = :dataIda", nativeQuery = true) public
	 * Destinos Buscar(String embarque, String destino, LocalDate dataIda);
	 */

	@Query(value = "select * from destinos where embarque = :embarque and destino = :destino", nativeQuery = true)
	
	public List<Destinos> BuscarPassagem(String embarque, String destino);


}
