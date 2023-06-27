import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
    List<Funcionario> funcionarios = new ArrayList<>();
    static List<Hospede> hospedes = new ArrayList<>();
    List<Quarto> quartos = new ArrayList<>();
    
    public Hotel(List<Funcionario> funcionarios, List<Quarto> quartos) {
        this.funcionarios = funcionarios;
        //this.hospedes = hospedes;
        this.quartos = quartos;
    }

    public void imprimirFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Setor: " + funcionario.getClass());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Data Admissão: " + funcionario.getDataAdmissao());
            System.out.println("Data Saída: " + funcionario.getDataSaida() == null ? "Contrato vigente" : funcionario.getDataSaida());
            System.out.println("-------------");
        }
    }

    public void imprimirHospedes() {
        for (Hospede hospede : hospedes) {
            System.out.println("Nome: " + hospede.getNome());
            System.out.println(hospede.getReserva().getQuarto());
            System.out.println("Diárias: " + hospede.getReserva().getDuracao());
            System.out.println("-------------");
        }
    }

    public void contratarCandidato(Pessoa candidato) {
        System.out.println("Contratando o candidato " + candidato.getNome());
        
        // todos funcionários terão o mesmo salário (por enquanto)
        Funcionario novoFuncionario = new Funcionario(2000, new Date());
        funcionarios.add(novoFuncionario);
    }

    public void demitirFuncionario(Funcionario funcionario) {
        System.out.println("Demitindo o funcionario " + funcionario.getNome());
        
        funcionarios.remove(funcionario);
    }
}
