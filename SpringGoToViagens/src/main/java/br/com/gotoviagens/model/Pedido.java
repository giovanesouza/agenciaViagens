package br.com.gotoviagens.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	// ATRIBUTOS
	
	@Id
	// IDENTITY = CHAVE PRIMÁRIA E AUTOINCREMENT
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPedido;

	@Column(nullable = false, name = "dataPedido")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataPedido;
	
	@Column(nullable = false)
    private BigDecimal precoTotal;
	
	@Column(nullable = false, length = 20)
    private String formaPagamento;
	
	@Column(nullable = false, length = 20)
    private String status;
	
	
	// CÓDIGO NOVO
	
	// MUITOS PEDIDOS PODEM SER REALIZADOS POR UM USUÁRIO
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	// MUITOS PEDIDOS PODEM ESTAR RELACIONADOS COM O MESMO DESTINO
	@ManyToOne
	@JoinColumn(name = "destino_id")
	private Destinos destinos;
		
	public Pedido() {}

	// CONSTRUTOR
	public Pedido(Long idPedido, LocalDate dataPedido, BigDecimal precoTotal, String formaPagamento, String status,
			Usuario usuario, Destinos destinos) {
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.precoTotal = precoTotal;
		this.formaPagamento = formaPagamento;
		this.status = status;
		this.usuario = usuario;
		this.destinos = destinos;
	}

	
	// GETTERS E SETTERS
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}

	
	// HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(dataPedido, destinos, formaPagamento, idPedido, precoTotal, status, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(dataPedido, other.dataPedido) && Objects.equals(destinos, other.destinos)
				&& Objects.equals(formaPagamento, other.formaPagamento) && Objects.equals(idPedido, other.idPedido)
				&& Objects.equals(precoTotal, other.precoTotal) && Objects.equals(status, other.status)
				&& Objects.equals(usuario, other.usuario);
	}

	
	// TO STRING
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", dataPedido=" + dataPedido + ", precoTotal=" + precoTotal
				+ ", formaPagamento=" + formaPagamento + ", status=" + status + ", usuario=" + usuario + ", destinos="
				+ destinos + "]";
	}

	

	
	
}
