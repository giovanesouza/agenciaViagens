package br.com.gotoviagens.model;

import java.math.BigDecimal;
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
@Table(name = "destinos")
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
	    private BigDecimal preco;

		@Column(nullable = false, length = 20)
	    private String categoria;
		
		@Column(nullable = false)
	    private int quantidade;
		
		@Column(nullable = false, length = 20)
	    private String condicao;
		
		@Column(nullable = false, name = "dataIda")
	    @DateTimeFormat(iso = ISO.DATE)
	    private LocalDate dataIda;
	
		@Column(nullable = true, name = "dataVolta")
	    @DateTimeFormat(iso = ISO.DATE)
	    private LocalDate dataVolta;
		
		public Destinos() {}

		public Destinos(Long id, String destino, String embarque, BigDecimal preco, String categoria, int quantidade,
				String condicao, LocalDate dataIda, LocalDate dataVolta) {

			this.id = id;
			this.destino = destino;
			this.embarque = embarque;
			this.preco = preco;
			this.categoria = categoria;
			this.quantidade = quantidade;
			this.condicao = condicao;
			this.dataIda = dataIda;
			this.dataVolta = dataVolta;
		}

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

		public BigDecimal getPreco() {
			return preco;
		}

		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
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

		@Override
		public int hashCode() {
			return Objects.hash(categoria, condicao, dataIda, dataVolta, destino, embarque, id, preco, quantidade);
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
					&& Objects.equals(id, other.id) && Objects.equals(preco, other.preco)
					&& quantidade == other.quantidade;
		}

		@Override
		public String toString() {
			return "Destinos [id=" + id + ", destino=" + destino + ", embarque=" + embarque + ", preco=" + preco
					+ ", categoria=" + categoria + ", quantidade=" + quantidade + ", condicao=" + condicao
					+ ", dataIda=" + dataIda + ", dataVolta=" + dataVolta + "]";
		}

		
		
		
}
