package br.com.gotoviagens.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(nullable = false)
	private Long idUsuario;
	
	@Column(nullable = false, name = "dataPedido")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataPedido;
	
	@Column(nullable = false)
    private float precoTotal;
	
	@Column(nullable = false, length = 20)
    private String formaPagamento;
	
	@Column(nullable = false, length = 20)
    private String status;

	// CONSTRUTOR
	public Pedido(Long idPedido, Long idUsuario, LocalDate dataPedido, float precoTotal, String formaPagamento,
			String status) {
		super();
		this.idPedido = idPedido;
		this.idUsuario = idUsuario;
		this.dataPedido = dataPedido;
		this.precoTotal = precoTotal;
		this.formaPagamento = formaPagamento;
		this.status = status;
	}

	
	//GETTERS E SETTERS
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(float precoTotal) {
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


	// HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(dataPedido, formaPagamento, idPedido, idUsuario, precoTotal, status);
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
		return Objects.equals(dataPedido, other.dataPedido) && Objects.equals(formaPagamento, other.formaPagamento)
				&& Objects.equals(idPedido, other.idPedido) && Objects.equals(idUsuario, other.idUsuario)
				&& Float.floatToIntBits(precoTotal) == Float.floatToIntBits(other.precoTotal)
				&& Objects.equals(status, other.status);
	}


	// TO STRING
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", idUsuario=" + idUsuario + ", dataPedido=" + dataPedido
				+ ", precoTotal=" + precoTotal + ", formaPagamento=" + formaPagamento + ", status=" + status + "]";
	}
	
	
	
}
