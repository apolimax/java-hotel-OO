import java.util.Date;

public class Camareira extends Funcionario {
    public Camareira(float salario, Date dataAdmissao) {
        super(salario, dataAdmissao);
        //TODO Auto-generated constructor stub
    }

    public void limparQuarto(Quarto quarto) {
        System.out.println("Limpando o quarto de número " + quarto.getNumero() + "do " + quarto.getAndar() + "o andar");
    }
}
