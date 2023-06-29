import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    static List<Funcionario> funcionarios = new ArrayList<>();
    static List<Hospede> hospedes = new ArrayList<>();
    List<Quarto> quartos = new ArrayList<>();
    
    public void imprimirFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("A lista de funcionários está vazia");
            return;
        }
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Profissão: " + funcionario.getClass());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Data Admissão: " + funcionario.getDataAdmissao());
            System.out.println("Data Saída: " + funcionario.getDataSaida() == null ? "Contrato vigente" : funcionario.getDataSaida());
            System.out.println("-------------");
        }
    }

    public void imprimirHospedes() {
        if (hospedes.isEmpty()) {
            System.out.println("A lista de hóspedes está vazia");
            return;
        }
        for (Hospede hospede : hospedes) {
            System.out.println("Nome: " + hospede.getNome());
            System.out.println(hospede.getReserva().getQuarto());
            System.out.println("Diárias: " + hospede.getReserva().getDuracao());
            System.out.println("-------------");
        }
    }

    public void demandarServicosRH(Scanner sc) {
        try {
            System.out.println("Digite 1 para contratar um novo funcionário");
            System.out.println("Digite 2 demitir um funcionário");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    RH.contratarCandidato(sc);
                    break;
                case 2:
                    RH.demitirFuncionario(sc);
                    break;
                default:
                    break;
            }
        } catch (InputMismatchException e) {
           System.out.println("Opção inválida " + e);
        }
    }

}
