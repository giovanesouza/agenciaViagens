package br.com.gotoviagens.model;


import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	// ATRIBUTOS
	
	@Id
	// IDENTITY = CHAVE PRIMÁRIA E AUTOINCREMENT
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
    private String nome;
	
	@Column(nullable = false, length = 20, unique = true)
    private String cpf;
	
	@Column(nullable = true, length = 20, unique = true)
    private String telefone;
	
	@Column(nullable = false, length = 50, unique = true)
    private String email;
	
	@Column(nullable = false)
    private String senha;
	
	
	//CÓDIGO NOVO 
	
	@OneToMany(mappedBy = "usuario")
	private List<Pedido> pedido;

	
	public Usuario() {}

	// CONSTRUTOR
	public Usuario(Long id, String nome, String cpf, String telefone, String email, String senha, List<Pedido> pedido) {

		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.pedido = pedido;
	}


	// GETTERS E SETTERS
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<Pedido> getPedido() {
		return pedido;
	}


	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}


	// HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id, nome, pedido, senha, telefone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(pedido, other.pedido)
				&& Objects.equals(senha, other.senha) && Objects.equals(telefone, other.telefone);
	}


	// TO STRING
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email
				+ ", senha=" + senha + ", pedido=" + pedido + "]";
	}

	

	
}
