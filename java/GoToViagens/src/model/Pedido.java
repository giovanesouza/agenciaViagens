package model;

import java.util.Date;

public class Pedido extends Passagem {
	
    private int idPedido, idUsuario, matFunc;
    private Date dataPedido;
    private String pagamento, statusPedido;
    private float precoTotal;
    
  
    public int getIdPedido() {
        return idPedido;
    }
    

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    
    public int getIdUsuario() {
        return idUsuario;
    }
    

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    public int getMatFunc() {
    	return matFunc;
    }
    
    public void setMatFunc(int matFunc) {
    	this.matFunc = matFunc;
    }
    

    public Date getDataPedido() {
        return dataPedido;
    }
    

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
    

    public String getPagamento() {
        return pagamento;
    }
    
    
      
    public String getStatusPedido() {
    	return statusPedido;
    }
    
    public void setStatusPedido(String statusPedido) {
    	this.statusPedido = statusPedido;
    }
    

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
    

    public float getPrecoTotal() {
        return precoTotal;
    }
    

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
    

  
    
}

