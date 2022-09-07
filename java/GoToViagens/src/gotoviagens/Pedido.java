package gotoviagens;

import java.util.Date;

public class Pedido extends Passagem {
	
	// PRECOTOTAL, FORMA_PAG, MAT_FUNC, CPF_CLI, NOME_CLI, DATA_PEDIDO
    
    private int idPedido, matFunc;
    private Date dataPedido;
    private String pagamento, cpfCli, nomeCli;
    private float precoTotal;
    
  
    public int getIdPedido() {
        return idPedido;
    }
    

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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
    
    
    public String getCpfCli() {
    	return cpfCli;
    }
    
    public void setCpfCli(String cpfCli) {
    	this.cpfCli = cpfCli;
    }
    
    
    public String getNomeCli() {
    	return nomeCli;
    }
    
    public void setNomeCli(String nomeCli) {
    	this.nomeCli = nomeCli;
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

