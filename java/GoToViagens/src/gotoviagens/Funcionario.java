package gotoviagens;

public class Funcionario extends Departamento {
    
    private int matricula;
    private String nome;
    private String cargo;
    private float salario;
    

    public int getMatricula() {
        return matricula;
    }
    

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    

    public String getNome() {
        return nome;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public String getCargo() {
        return cargo;
    }
    

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    

    public float getSalario() {
        return salario;
    }
    

    public void setSalario(float salario) {
        this.salario = salario;
    }
    

    public boolean trabalhando() {

        return false;
    }
    
    
}
