package br.com.gotoviagens.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	// ATRIBUTOS

	@Id
	// IDENTITY = CHAVE PRIMÁRIA E AUTOINCREMENT
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matricula;

	@Column(nullable = false, length = 20, unique = true)
	private String cpf;

	@Column(nullable = false, length = 50)
	private String nome;

	@Column(nullable = false, name = "dataAdmissao")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataAdmissao;

	@Column(nullable = true, name = "dataDemissao")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataDemissao;

// MUITOS FUNCIONÁRIOS PARA UM CARGO	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cargo_id_fk", nullable = false)
	private Cargo cargo;

	@Column(nullable = false)
	private BigDecimal salario;

	public Funcionario() {
	}

	public Funcionario(Long matricula, String cpf, String nome, LocalDate dataAdmissao, LocalDate dataDemissao,
			Cargo cargo, BigDecimal salario) {

		this.matricula = matricula;
		this.cpf = cpf;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
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
		return Objects.hash(cargo, cpf, dataAdmissao, dataDemissao, matricula, nome, salario);
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
		return Objects.equals(cargo, other.cargo) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataAdmissao, other.dataAdmissao) && Objects.equals(dataDemissao, other.dataDemissao)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(nome, other.nome)
				&& Objects.equals(salario, other.salario);
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", cpf=" + cpf + ", nome=" + nome + ", dataAdmissao="
				+ dataAdmissao + ", dataDemissao=" + dataDemissao + ", cargo=" + cargo + ", salario=" + salario + "]";
	}
	
	

}
