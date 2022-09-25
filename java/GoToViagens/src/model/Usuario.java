package model;

import java.util.Date;

public class Usuario {
    
    private int id;
    private String nome, cpf, telefone, email, senha;
    private Date dataCadastro, dataAtualizacaoCadastro;
    private Boolean cadastrado, logado;
    
     
    public int getId() {
        return id;
    }
    

    public void setId(int id) {
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
    
    
    
    
    public Date getDataCadastro() {
        return dataCadastro;
    }
    

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
    public Date getDataAtualizacaoCadastro() {
        return dataAtualizacaoCadastro;
    }
    

    public void setDataAtualizacaoCadastro(Date dataAtualizacaoCadastro) {
        this.dataAtualizacaoCadastro = dataAtualizacaoCadastro;
    }
    
    

    public Boolean getCadastrado() {
        return cadastrado;
    }
    

    public void setCadastrado(Boolean cadastrado) {
        this.cadastrado = cadastrado;
    }
    

     


    public Boolean getLogado() {
        return logado;
    }
    

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }
    


   
    public void finalizarCompra() {
       
    }
    

    public void cancelarCompra() {
       
    }
    
    
}

