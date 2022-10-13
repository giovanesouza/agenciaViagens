package br.com.gotoviagens.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passagem")
public class Passagem {

	// ATRIBUTOS
	
	@Id
	// IDENTITY = CHAVE PRIMÁRIA E AUTOINCREMENT
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPassagem;
	
	@Column(nullable = true)
	private int idDestino;
	
	@Column(nullable = true)
	private int quantidade;

	// CONSTRUTOR
	public Passagem(Long idPassagem, int idDestino, int quantidade) {
		super();
		this.idPassagem = idPassagem;
		this.idDestino = idDestino;
		this.quantidade = quantidade;
	}

	// GETTERS E SETTERS
	public Long getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(Long idPassagem) {
		this.idPassagem = idPassagem;
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	// HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(idDestino, idPassagem, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passagem other = (Passagem) obj;
		return idDestino == other.idDestino && Objects.equals(idPassagem, other.idPassagem)
				&& quantidade == other.quantidade;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Passagem [idPassagem=" + idPassagem + ", idDestino=" + idDestino + ", quantidade=" + quantidade + "]";
	}
	
	
}
