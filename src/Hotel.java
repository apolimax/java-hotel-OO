import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    static List<Funcionario> funcionarios = new ArrayList<>();
    static List<Hospede> hospedes = new ArrayList<>();
    List<Quarto> quartos = new ArrayList<>();

    public String getDepartamento(Funcionario funcionario) {
        boolean isLimpeza =  funcionario instanceof Camareira;
        boolean isRH =  funcionario instanceof RH;
        boolean isRestaurante =  funcionario instanceof Cozinheiro;
        //boolean isRecepcao =  funcionario instanceof Recepcionista;

        if (isLimpeza) {
            return "Limpeza";
        } else if (isRH) {
            return "Recursos Humanos";
        } else if (isRestaurante) {
            return "Restaurante";
        } else {
            return "Recepção";
        }
    }
    
    public void imprimirFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("A lista de funcionários está vazia");
            return;
        }
        for (Funcionario funcionario : funcionarios) {
            System.out.println();
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Departamento: " + getDepartamento(funcionario));
            System.out.println("-------------");
        }
    }

    public void imprimirFuncionario(Scanner sc) {
        if (funcionarios.isEmpty()) {
            System.out.println("A lista de funcionários está vazia");
            return;
        }

        System.out.println("Digite o nome do funcionário");
        String nomeFuncionario = sc.next();
        Funcionario f = null;

        for (Funcionario funcionario : funcionarios) {
           if (funcionario.getNome().toLowerCase().equals(nomeFuncionario.toLowerCase())) {
                f = funcionario;
           }
        }

        if (f == null) {
            System.out.println("Funcionário não encontrado");
        } else {
            System.out.println();
            System.out.println("Nome: " + f.getNome());
            System.out.println("Departamento: " + getDepartamento(f));
            System.out.println("Salário: " + f.getSalario());
            System.out.println("Data Admissão: " + f.getDataAdmissao());
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
