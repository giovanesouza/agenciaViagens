package br.com.gotoviagens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "trabalheConosco")
public class TrabalheConosco {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
    private String nome;
	
	@Column(nullable = false, length = 50)
    private String email;
	
	@Column(nullable = false, length = 15)
    private String cargo;
	
	@Column(nullable = false)
    private String curriculo;
	
	
	public TrabalheConosco() {}


	public TrabalheConosco(Long id, String nome, String email, String cargo, String curriculo) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
		this.curriculo = curriculo;
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


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getCurriculo() {
		return curriculo;
	}


	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

	
	
	
	
	
	
}
