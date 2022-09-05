package gotoviagens;

public class Passagem extends Destino {
    

    private int idPassagem;
    private int quantidade;
    
    
    
    public int getIdPassagem() {
        return idPassagem;
    }
    

    public void setIdPassagem(int idPassagem) {
        this.idPassagem = idPassagem;
    }
    

    public int getQuantidade() {
        return quantidade;
    }

 
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    


    public boolean realizarPedido() {
   
        return false;
    }
    

    public boolean cancelarPedido() {

        return false;
    }
    

    public boolean disponProd() {
    	
        return false;
    }
    
    
}

