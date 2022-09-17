package model;

import java.util.Date;

public class Usuario extends Cliente {
    

    private int idUsuario;
    private Boolean cadastrado;
    private String emailUsuario, senha, nome;
    private Boolean logado;
    private Date dataCadastro;
    
     
    public int getIdUsuario() {
        return idUsuario;
    }
    

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    

    public Boolean getCadastrado() {
        return cadastrado;
    }
    

    public void setCadastrado(Boolean cadastrado) {
        this.cadastrado = cadastrado;
    }
    

    public String getEmailUsuario() {
    	return emailUsuario;
    }
    
    public void setEmailUsuario(String emailUsuario) {
    	this.emailUsuario = emailUsuario;
    }
    
    public String getSenha() {
        return senha;
    }
    

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public String getNome() {
        return nome;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getLogado() {
        return logado;
    }
    

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }
    

    public Date getDataCadastro() {
        return dataCadastro;
    }
    

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    


    public void realizarCadastro() {

    }
    

    public void cancelarCadastro() {
       
    }
    

    public void finalizarCompra() {
       
    }
    

    public void cancelarCompra() {
       
    }
    
    
}
