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
        System.out.println("--- Relação de funcionários ---");
        if (funcionarios.isEmpty()) {
            System.out.println("A lista de funcionários está vazia!");
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
            System.out.println("--- Detalhes de um funcionário ---");
            System.out.println("A lista de funcionários está vazia!");
            return;
        }
        
        System.out.print("Digite o nome do funcionário: ");
        String nomeFuncionario = sc.next();
        Funcionario f = null;
        
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().toLowerCase().equals(nomeFuncionario.toLowerCase())) {
                f = funcionario;
            }
        }
        
        System.out.println("--- Detalhes de um funcionário ---");
        if (f == null) {
            System.out.println("Funcionário não encontrado");
        } else {
            System.out.println();
            System.out.println("Nome: " + f.getNome());
            System.out.println("Departamento: " + getDepartamento(f));
            System.out.println("Salário: R$ " + f.getSalario());
            System.out.println("Data Admissão: " + f.getDataAdmissao());
            System.out.println("-------------");
        }
    }

    public void imprimirHospedes() {
        System.out.println("--- Relação de hóspedes ---");
        if (hospedes.isEmpty()) {
            System.out.println("A lista de hóspedes está vazia!");
            return;
        }
        for (Hospede hospede : hospedes) {
            System.out.println();
            System.out.println("Nome: " + hospede.getNome());
            System.out.println(hospede.getReserva().getQuarto());
            System.out.println("-------------");
        }
    }

    public void imprimirHospede(Scanner sc) {
        if (hospedes.isEmpty()) {
            System.out.println("--- Detalhes de um hóspede ---");
            System.out.println("A lista de hóspedes está vazia!");
            return;
        }
        System.out.print("Digite o nome do hóspede: ");
        String nommeHospede = sc.next();
        Hospede h = null;

        for (Hospede hospede : hospedes) {
           if (hospede.getNome().toLowerCase().equals(nommeHospede.toLowerCase())) {
                h = hospede;
           }
        }
        System.out.println("--- Detalhes de um hóspede ---");
        if (h == null) {
            System.out.println("Hóspede não encontrado");
        } else {
            System.out.println();
            System.out.println("Nome: " + h.getNome());
            System.out.println(h.getReserva().getQuarto());
            System.out.println("Data de check in: " + h.getReserva().getCheckIn());
            System.out.println("Data de check out: " + h.getReserva().getCheckOut());
            System.out.println("Diárias: " + h.getReserva().getDuracao());
            System.out.println("-------------");
        }
    }

    public void demandarServicosRH(Scanner sc) {
        int opt = 1;
        do {
            try {
                System.out.println("--- Recursos Humanos ---");
                System.out.println("Digite 1 para contratar um novo funcionário");
                System.out.println("Digite 2 demitir um funcionário");
                System.out.println("Digite 3 para sair");
                opt = sc.nextInt();
    
                switch (opt) {
                    case 1:
                        RH.contratarCandidato(sc);
                        break;
                    case 2:
                        RH.demitirFuncionario(sc);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Opção inválida, tente novamente!");
                        break;
                }
            } catch (InputMismatchException e) {
               System.out.println("Opção inválida " + e);
               return;
            }
            
        } while (opt != 3);

    }

    public void demandarServicosRecepcao(Scanner sc) {
        System.out.println("--- Recepção ---");
        try {
            System.out.println("Digite 1 para fazer uma nova reserva");
            System.out.println("Digite 2 para cancelar uma reserva");
            System.out.println("Digite 3 para sair");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    Recepcionista.fazerReserva(sc);
                    break;
                case 2:
                    Recepcionista.cancelarReserva(sc);
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        } catch (InputMismatchException e) {
           System.out.println("Opção inválida " + e);
        }
    }

    public void demandarServicoRestaurante(Scanner sc) {
        System.out.println("--- Restaurante ---");
    	try {
    		System.out.println("--- CARDÁPIO ---");
    		System.out.println("Digite 1 para Feijoada");
            System.out.println("Digite 2 para Macarronada");
            System.out.println("Digite 3 para Salada");
            System.out.println("Digite 4 para sair");
        	
        	int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    Cozinheiro.cozinhar("Feijoada");
                    break;
                case 2:
                	Cozinheiro.cozinhar("Macarronada");
                    break;
                case 3:
                	Cozinheiro.cozinhar("Salada");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida " + e);
        }	
    }

}
