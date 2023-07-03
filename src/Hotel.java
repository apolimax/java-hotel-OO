import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    static List<Funcionario> funcionarios = new ArrayList<>();
    static List<Hospede> hospedes = new ArrayList<>();
    static List<Quarto> quartos = new ArrayList<>();

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
            System.out.println(  "\nNome: " + funcionario.getNome()
                               + "\nDepartamento: " + getDepartamento(funcionario)
                               + "\n-------------");
        }
    }

    public void imprimirFuncionario(Scanner sc) {
        if (funcionarios.isEmpty()) {
            System.out.println(  "--- Detalhes de um funcionário ---"
                               + "\nA lista de funcionários está vazia!");
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
            System.out.println(  "\nNome: " + f.getNome()
                               + "\nDepartamento: " + getDepartamento(f)
                               + "\nSalário: R$ " + f.getSalario()
                               + "\nData Admissão: " + f.getDataAdmissao()
                               + "\n-------------");
        }
    }

    public void imprimirHospedes() {
        System.out.println("--- Relação de hóspedes ---");
        if (hospedes.isEmpty()) {
            System.out.println("A lista de hóspedes está vazia!");
            return;
        }
        for (Hospede hospede : hospedes) {
            System.out.println(  "\n\nNome: " + hospede.getNome()
                               + "\n" + hospede.getReserva().getQuarto()
                               + "\n-------------");
        }
    }

    public void imprimirHospede(Scanner sc) {
        if (hospedes.isEmpty()) {
            System.out.println(  "--- Detalhes de um hóspede ---" 
                               + "\nA lista de hóspedes está vazia!");
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
            System.out.println(  "\nNome: " + h.getNome()
                               + "\n" + h.getReserva().getQuarto().toString()
                               + "\nData de check in: " + h.getReserva().getCheckIn()
                               + "\nData de check out: " + h.getReserva().getCheckOut()
                               + "\nDiárias: " + h.getReserva().getDuracao()
                               + "\n-------------");
        }
    }

    public void demandarServicosRH(Scanner sc) {
        int opt = 1;
        do {
            try {
                System.out.println(  "--- Recursos Humanos ---"
                                   + "\nDigite 1 para contratar um novo funcionário"
                                   + "\nDigite 2 demitir um funcionário"
                                   + "\nDigite 3 para sair");

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
               System.out.println("\nOpção inválida! Error: " + e);
               return;
            }
            
        } while (opt != 3);

    }

    public void demandarServicosRecepcao(Scanner sc) {  
        System.out.println("--- Recepção ---");      
        try {
            System.out.println(  "\nDigite 1 para fazer uma nova reserva"
                               + "\nDigite 2 para cancelar uma reserva"
                               + "\nDigite 3 para sair");

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
           System.out.println("\nOpção inválida! Error: " + e);
        }
    }

    public void demandarServicosLimpeza(Scanner sc) {  
        System.out.println("--- Limpeza ---");      
        try {
            System.out.println(  "\nDigite 1 para solicitar limpeza"
                               + "\nDigite 2 para cancelar uma solicitação de limpeza"
                               + "\nDigite 3 para sair");

            int opt = sc.nextInt();

            System.out.println();

            switch (opt) {
                case 1:
                    Camareira.solicitarLimpeza(sc);
                    break;
                case 2:
                    Camareira.cancelarLimpeza(sc);
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        } catch (InputMismatchException e) {
           System.out.println("\nOpção inválida! Error: " + e);
        }
    }

    public void demandarServicoRestaurante(Scanner sc) {
        System.out.println("--- Restaurante ---");
    	try {
    		System.out.println(  "--- CARDÁPIO ---"
    		                   + "\nDigite 1 para Feijoada"
                               + "\nDigite 2 para Macarronada"
                               + "\nDigite 3 para Salada"
                               + "\nDigite 4 para sair");
        	
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
            System.out.println("\nOpção inválida! Error: " + e);
        }	
    }

}
