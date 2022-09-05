package gotoviagens;

import java.sql.Date;

public class Pedido extends Passagem {
    
    private int idPedido;
    private Date dataPedido;
    private String pagamento;
    private float precoTotal;
    
    
    
    public int getIdPedido() {
        return idPedido;
    }
    

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    

    public Date getDataPedido() {
        return dataPedido;
    }
    

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
    

    private String getPagamento() {
        return pagamento;
    }
    

    private void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
    

    private float getPrecoTotal() {
        return precoTotal;
    }
    

    private void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
    

  
    
}

