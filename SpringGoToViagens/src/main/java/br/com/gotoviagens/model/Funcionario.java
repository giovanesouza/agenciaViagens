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
public class Funcionario {
	
	// ATRIBUTOS
	
	@Id
	// IDENTITY = CHAVE PRIMÁRIA E AUTOINCREMENT
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long matricula;
	
	@Column(nullable = false)
	private Long codDepartamento;
	
	@Column(nullable = false, length = 50)
    private String nome;
	
	@Column(nullable = false, name = "dataAdimissao")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataAdimissao;
	
	@Column(nullable = true, name = "dataDemissao")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataDemissao;
   
	@Column(nullable = false, length = 20)
    private String cargo;
	
	@Column(nullable = false)
    private float salario;

// CONSTRUTOR
	public Funcionario(Long matricula, String nome, LocalDate dataAdimissao, LocalDate dataDemissao,
			Long codDepartamento, String cargo, float salario) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.dataAdimissao = dataAdimissao;
		this.dataDemissao = dataDemissao;
		this.codDepartamento = codDepartamento;
		this.cargo = cargo;
		this.salario = salario;
	}

	// GETTERS E SETTERS
	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataAdimissao() {
		return dataAdimissao;
	}

	public void setDataAdimissao(LocalDate dataAdimissao) {
		this.dataAdimissao = dataAdimissao;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Long getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(Long codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
	// HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(cargo, codDepartamento, dataAdimissao, dataDemissao, matricula, nome, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cargo, other.cargo) && codDepartamento == other.codDepartamento
				&& Objects.equals(dataAdimissao, other.dataAdimissao)
				&& Objects.equals(dataDemissao, other.dataDemissao) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(nome, other.nome)
				&& Float.floatToIntBits(salario) == Float.floatToIntBits(other.salario);
	}

	
	// TO STRING
	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", nome=" + nome + ", dataAdimissao=" + dataAdimissao
				+ ", dataDemissao=" + dataDemissao + ", codDepartamento=" + codDepartamento + ", cargo=" + cargo
				+ ", salario=" + salario + "]";
	}
	



	
	
}
