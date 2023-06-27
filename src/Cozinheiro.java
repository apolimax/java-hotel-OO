import java.util.Date;

public class Cozinheiro extends Funcionario {
    public Cozinheiro(float salario, Date dataAdmissao) {
        super(salario, dataAdmissao);
        //TODO Auto-generated constructor stub
    }

    public void cozinhar(String prato) {
        System.out.println("Cozinhando o prato " + prato);
    }
}
