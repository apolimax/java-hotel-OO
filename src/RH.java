import java.util.Date;

public class RH extends Funcionario {

    public RH(float salario, Date dataAdmissao) {
        super(salario, dataAdmissao);
        //TODO Auto-generated constructor stub
    }

    public void contratarCandidato(String candidato) {
        System.out.println("Contratando o candidato " + candidato);
        
        // TODO: perguntar nome do candidato
        // TODO: perguntar salário do candidato
        // TODO: perguntar departamento do candidato (cozinheiro, garçom, RH, recepcionista e camareira)
        Funcionario novoFuncionario = new Funcionario(2000, new Date());
        Hotel.funcionarios.add(novoFuncionario);
    }

    public void demitirFuncionario(Funcionario funcionario) {
        System.out.println("Demitindo o funcionario " + funcionario.getNome());
        // TODO: demitir funcionário a partir do seu nome
        Hotel.funcionarios.remove(funcionario);
    }
    
}
