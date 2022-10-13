package br.com.gotoviagens.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidade")
public class Unidade {
	
	@Id
	// IDENTITY = CHAVE PRIMÁRIA E AUTOINCREMENT
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long codUnidade;

	@Column(nullable = false, length = 20, unique = true)
    private String nome;
	
	@Column(nullable = false, length = 15, unique = true)
    private String telefone;
	
	@Column(nullable = false, length = 50, unique = true)
    private String email;
	
	@Column(nullable = false, length = 20)
    private String rua;
	
	@Column(nullable = false, length = 5)
    private String numero;
	
	@Column(nullable = false, length = 20)
    private String complemento;
	
	@Column(nullable = false, length = 20)
    private String bairro;
	
	@Column(nullable = false, length = 15)
    private String cidade;
	
	@Column(nullable = false, length = 15)
    private String estado;

	@Column(nullable = false, length = 8, unique = true)
    private String cep;

	// CONSTRUTOR
	public Unidade(Long codUnidade, String nome, String telefone, String email, String rua, String numero,
			String complemento, String bairro, String cidade, String estado, String cep) {
		super();
		this.codUnidade = codUnidade;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	// GETTERS E SETTERS
	public Long getCodUnidade() {
		return codUnidade;
	}

	public void setCodUnidade(Long codUnidade) {
		this.codUnidade = codUnidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
	// HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, codUnidade, complemento, email, estado, nome, numero, rua, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidade other = (Unidade) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(codUnidade, other.codUnidade)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(email, other.email)
				&& Objects.equals(estado, other.estado) && Objects.equals(nome, other.nome)
				&& Objects.equals(numero, other.numero) && Objects.equals(rua, other.rua)
				&& Objects.equals(telefone, other.telefone);
	}

	
	// TO STRING
	@Override
	public String toString() {
		return "Unidade [codUnidade=" + codUnidade + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + "]";
	}
	
	
	
	
}
