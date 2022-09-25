package model;

public class Empresa {

    private String cnpj, razaoSocial, nomeFantasia, unidade, endereco, telefone, email;

    public int codUnid;
    
    

    public String getCnpj() {
        return cnpj;
    }
    

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    

    public String getRazaoSocial() {
        return razaoSocial;
    }
    

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    

    public String getNomeFantasia() {
        return nomeFantasia;
    }
    

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    

    public int getCodUnid() {
        return codUnid;
    }
    

    public void setCodUnid(int codUnid) {
        this.codUnid = codUnid;
    }
    

    public String getUnidade() {
        return unidade;
    }
    

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    

    public String getEndereco() {
        return endereco;
    }
    

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
    

    //	MÉTODOS ESPECÍFICOS
    public boolean contratar() {

        return false;
    }
    

    public boolean demitir() {

        return false;
    }
    
    
}

