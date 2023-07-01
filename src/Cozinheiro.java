import java.util.Date;

public class Cozinheiro extends Funcionario {
    public Cozinheiro(String nome, byte idade, float salario, Date dataAdmissao) {
        super(nome, idade, salario, dataAdmissao);
        //TODO Auto-generated constructor stub
    }

    public static void cozinhar(String prato) {
        System.out.println("Cozinhando o prato " + prato);
    }
}
