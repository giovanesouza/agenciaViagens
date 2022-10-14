package br.com.gotoviagens.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "faleConosco")
public class FaleConosco {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
    private String nome;
	
	@Column(nullable = false, length = 50)
    private String email;
	
	@Column(nullable = false, length = 200)
    private String mensagem;
	
	@Column(nullable = true, name = "dataContato")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataContato;
	
	@Column(nullable = true, name = "dataResposta")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataResposta;
	
	@Column(nullable = true, length = 20)
    private String status;
	
	public FaleConosco() {}

	public FaleConosco(Long id, String nome, String email, String mensagem, LocalDate dataContato,
			LocalDate dataResposta, String status) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.mensagem = mensagem;
		this.dataContato = dataContato;
		this.dataResposta = dataResposta;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalDate getDataContato() {
		return dataContato;
	}

	public void setDataContato(LocalDate dataContato) {
		this.dataContato = dataContato;
	}

	public LocalDate getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(LocalDate dataResposta) {
		this.dataResposta = dataResposta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
