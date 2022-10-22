package br.com.gotoviagens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gotoviagens.model.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	

@Query(value = "select * from pedido where usuario_id = :usuario_id", nativeQuery = true)
public List<Pedido> buscarPedidosById(Long id);


}
