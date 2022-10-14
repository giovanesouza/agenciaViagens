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
@Table(name = "funcionario")
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
	
	@Column(nullable = false, name = "dataAdmissao")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataAdmissao;
	
	@Column(nullable = true, name = "dataDemissao")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataDemissao;
   
	@Column(nullable = false, length = 20)
    private String cargo;
	
	@Column(nullable = false)
    private BigDecimal salario;

	public Funcionario() {}

	public Funcionario(Long matricula, Long codDepartamento, String nome, LocalDate dataAdmissao,
			LocalDate dataDemissao, String cargo, BigDecimal salario) {
		
		this.matricula = matricula;
		this.codDepartamento = codDepartamento;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
		this.cargo = cargo;
		this.salario = salario;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Long getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(Long codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cargo, codDepartamento, dataAdmissao, dataDemissao, matricula, nome, salario);
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
		return Objects.equals(cargo, other.cargo) && Objects.equals(codDepartamento, other.codDepartamento)
				&& Objects.equals(dataAdmissao, other.dataAdmissao)
				&& Objects.equals(dataDemissao, other.dataDemissao) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(nome, other.nome) && Objects.equals(salario, other.salario);
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", codDepartamento=" + codDepartamento + ", nome=" + nome
				+ ", dataAdmissao=" + dataAdmissao + ", dataDemissao=" + dataDemissao + ", cargo=" + cargo
				+ ", salario=" + salario + "]";
	}

	
	
}
