package model;

public class Departamento extends Empresa {
    
    public int codDepartamento;
    private String nomeDepartamento;
    
    
    public int getCodDepartamento() {
        return codDepartamento;
    }
    

    public void setCodDepartamento(int codDepartamento) {
        this.codDepartamento = codDepartamento;
    }
    

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }
    

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }
    
    
    // INFORMAÇÕES DE EMPRESA
    public int getCodUnid() {
    	return codUnid;
    }
    
    public void setCodUnid(int codUnid) {
    	this.codUnid = codUnid;
    }
    
}

