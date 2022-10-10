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
@Table
public class Destinos {
	
	// ATRIBUTOS
	
		@Id
		// IDENTITY = CHAVE PRIMÁRIA E AUTOINCREMENT
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false, length = 20)
	    private String destino;
		
		@Column(nullable = false, length = 20)
	    private String embarque;
		
		@Column(nullable = false)
	    private float preco;

		@Column(nullable = false, length = 20)
	    private String categoria;
		
		@Column(nullable = false)
	    private int qtdDisponivel;
		
		@Column(nullable = false, length = 20)
	    private String condicao;
		
		@Column(nullable = false, name = "dataIda")
	    @DateTimeFormat(iso = ISO.DATE)
	    private LocalDate dataIda;
	
		@Column(nullable = true, name = "dataVolta")
	    @DateTimeFormat(iso = ISO.DATE)
	    private LocalDate dataVolta;

		// CONSTRUTOR 
		public Destinos(Long id, String destino, String embarque, float preco, String categoria, int qtdDisponivel,
				String condicao, LocalDate dataIda, LocalDate dataVolta) {
			super();
			this.id = id;
			this.destino = destino;
			this.embarque = embarque;
			this.preco = preco;
			this.categoria = categoria;
			this.qtdDisponivel = qtdDisponivel;
			this.condicao = condicao;
			this.dataIda = dataIda;
			this.dataVolta = dataVolta;
		}

		// GETTERS E SETTERS
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDestino() {
			return destino;
		}

		public void setDestino(String destino) {
			this.destino = destino;
		}

		public String getEmbarque() {
			return embarque;
		}

		public void setEmbarque(String embarque) {
			this.embarque = embarque;
		}

		public float getPreco() {
			return preco;
		}

		public void setPreco(float preco) {
			this.preco = preco;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public int getQtdDisponivel() {
			return qtdDisponivel;
		}

		public void setQtdDisponivel(int qtdDisponivel) {
			this.qtdDisponivel = qtdDisponivel;
		}

		public String getCondicao() {
			return condicao;
		}

		public void setCondicao(String condicao) {
			this.condicao = condicao;
		}

		public LocalDate getDataIda() {
			return dataIda;
		}

		public void setDataIda(LocalDate dataIda) {
			this.dataIda = dataIda;
		}

		public LocalDate getDataVolta() {
			return dataVolta;
		}

		public void setDataVolta(LocalDate dataVolta) {
			this.dataVolta = dataVolta;
		}
		

		// HASHCODE E EQUALS
		@Override
		public int hashCode() {
			return Objects.hash(categoria, condicao, dataIda, dataVolta, destino, embarque, id, preco, qtdDisponivel);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Destinos other = (Destinos) obj;
			return Objects.equals(categoria, other.categoria) && Objects.equals(condicao, other.condicao)
					&& Objects.equals(dataIda, other.dataIda) && Objects.equals(dataVolta, other.dataVolta)
					&& Objects.equals(destino, other.destino) && Objects.equals(embarque, other.embarque)
					&& Objects.equals(id, other.id) && Float.floatToIntBits(preco) == Float.floatToIntBits(other.preco)
					&& qtdDisponivel == other.qtdDisponivel;
		}

		// TO STRING
		@Override
		public String toString() {
			return "Destinos [id=" + id + ", destino=" + destino + ", embarque=" + embarque + ", preco=" + preco
					+ ", categoria=" + categoria + ", qtdDisponivel=" + qtdDisponivel + ", condicao=" + condicao
					+ ", dataIda=" + dataIda + ", dataVolta=" + dataVolta + "]";
		}
		
		
		
		
}
