import java.util.Date;

public class Funcionario extends Pessoa {
    private float salario;
    private Date dataAdmissao;
    private Date dataSaida = null;

    public Funcionario(String nome, byte idade, float salario, Date dataAdmissao) {
        super(nome, idade);
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }
    
    public Date getDataAdmissao() {
        return dataAdmissao;
    }
    
    public Date getDataSaida() {
        return dataSaida;
    }
    public float getSalario() {
        return salario;
    }
    
    public void setSalario(float salario) {
        this.salario = salario;
    }

}
