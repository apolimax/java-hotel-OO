import java.util.Date;

public class Funcionario extends Pessoa {
    private float salario;
    private Date dataAdmissao;

    public Funcionario(String nome, byte idade, float salario, Date dataAdmissao) {
        super(nome, idade);
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }
    
    public Date getDataAdmissao() {
        return dataAdmissao;
    }
    
    public float getSalario() {
        return salario;
    }
    
    public void setSalario(float salario) {
        this.salario = salario;
    }

}
