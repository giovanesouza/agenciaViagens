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
public class Usuario {

	// ATRIBUTOS
	
	@Id
	// IDENTITY = CHAVE PRIMÁRIA E AUTOINCREMENT
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
    private String nome;
	
	@Column(nullable = false, length = 11, unique = true)
    private String cpf;
	
	@Column(nullable = true, length = 11, unique = true)
    private String telefone;
	
	@Column(nullable = false, length = 50, unique = true)
    private String email;
	
	@Column(nullable = false, length = 12)
    private String senha;
	
	@Column(nullable = false, name = "dataCadastro")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataCadastro;
	
	@Column(nullable = true, name = "dataAtualizacaoCadastro")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataAtualizacaoCadastro;
	
	public Usuario() {}
	
	// MÉTODO CONSTRUTOR
	public Usuario(Long id, String nome, String cpf, String telefone, String email, String senha,
			LocalDate dataCadastro, LocalDate dataAtualizacaoCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacaoCadastro = dataAtualizacaoCadastro;
	}

	
	// GETTERS E SETTERS
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataAtualizacaoCadastro() {
		return dataAtualizacaoCadastro;
	}

	public void setDataAtualizacaoCadastro(LocalDate dataAtualizacaoCadastro) {
		this.dataAtualizacaoCadastro = dataAtualizacaoCadastro;
	}

	
	// HASHCODE E EQUALS
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataAtualizacaoCadastro, dataCadastro, email, id, nome, senha, telefone);
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
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataAtualizacaoCadastro, other.dataAtualizacaoCadastro)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(email, other.email)
				&& id == other.id && Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha)
				&& Objects.equals(telefone, other.telefone);
	}

	
	
	// TOSTRING
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email
				+ ", senha=" + senha + ", dataCadastro=" + dataCadastro + ", dataAtualizacaoCadastro="
				+ dataAtualizacaoCadastro + "]";
	}
	
	
	
}
