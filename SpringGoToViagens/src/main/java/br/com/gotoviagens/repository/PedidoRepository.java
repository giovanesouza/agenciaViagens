package br.com.gotoviagens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gotoviagens.model.Pedido;
//import br.com.gotoviagens.model.Usuario;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	/*
	 * @Query(value = "select * from pedido where usuario_id = :id", nativeQuery =
	 * true) public List<Pedido> buscarPedidosById(Long id); // usuario_id
	 */

	@Query(value = "select * from pedido where usuario_id = :id", nativeQuery = true)
	public List<Pedido> findByUserId(Long id);

	
	//List<Pedido> findByUsuario(Usuario usuario);
	
	
	
}
