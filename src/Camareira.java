import java.util.Date;

public class Camareira extends Funcionario {
    public Camareira(String nome, byte idade, float salario, Date dataAdmissao) {
        super(nome, idade, salario, dataAdmissao);
        //TODO Auto-generated constructor stub
    }

    public void limparQuarto(Quarto quarto) {
        System.out.println("Limpando o quarto de número " + quarto.getNumero() + "do " + quarto.getAndar() + "o andar");
    }
}
