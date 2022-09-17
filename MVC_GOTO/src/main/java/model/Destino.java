package model;

public class Destino {
    
    private int idDestino;
    private String nomeDestino, categoriaDestino, condicao;
    private float precoUnit;
    private int qtdDisponivel;
    
    
    public int getIdDestino() {
        return idDestino;
    }
    
    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }
    
    
    public String getNomeDestino() {
        return nomeDestino;
    }
    

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }
    

    public String getCategoriaDestino() {
        return categoriaDestino;
    }
    

    public void setCategoriaDestino(String categoriaDestino) {
        this.categoriaDestino = categoriaDestino;
    }
    

    public float getPrecoUnit() {
        return this.precoUnit;
    }
    

    public void setPrecoUnit(float precoUnit) {
        this.precoUnit = precoUnit;
    }
    

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }
    

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }
    
    public String getCondicao() {
    	return condicao;
    }
    
    public void setCondicao(String condicao) {
    	this.condicao = condicao;
    }


    public void cadastrarDestino() {

    }
    


    public void excluirDestino() {
        //TODO
    }
    

    public void addQtd() {
        //TODO
    }
    
    
}

