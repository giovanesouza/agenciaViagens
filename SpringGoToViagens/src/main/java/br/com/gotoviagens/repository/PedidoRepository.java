package br.com.gotoviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gotoviagens.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
