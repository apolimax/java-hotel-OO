import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {        
        Scanner sc = new Scanner(System.in);
        Hotel hotelIMD = new Hotel();

        int opt = 1;
        do {
            try {
                System.out.print(  "\n--- Sistema de Reservas do Hotel IMD ---\n"
                                 + "\nOpções:"
                                 + "\n\t [1] Listar funcionários"
                                 + "\n\t [2] Listar dados de um funcionário pelo seu nome"
                                 + "\n\t [3] Listar hóspedes"
                                 + "\n\t [4] Listar dados de um hóspede pelo seu nome"
                                 + "\n\t [5] Demandar serviços de recursos humanos"
                                 + "\n\t [6] Demandar serviços de recepção"
                                 + "\n\t [7] Demandar serviços de limpeza de quarto"
                                 + "\n\t [8] Demandar serviços de restaurante"
                                 + "\n\t [0] Finalizar o programa"
                                 + "\nDigite sua opção [0-8]: ");

                opt = sc.nextInt();

                System.out.println();

                if(opt < 0 || opt > 8) { 
                    System.out.println("Opção inválida! Tente novamente.");
                } else {
                    switch (opt) {
                        case 0:
                            System.out.println("Programa finalizado.");
                            break;
                        case 1:
                            hotelIMD.imprimirFuncionarios();
                            break;
                        case 2:
                            hotelIMD.imprimirFuncionario(sc);
                            break;
                        case 3:
                            hotelIMD.imprimirHospedes();
                            break;
                        case 4:
                            hotelIMD.imprimirHospede(sc);
                            break;
                        case 5:
                            hotelIMD.demandarServicosRH(sc);
                            break;
                        case 6:
                            hotelIMD.demandarServicosRecepcao(sc);
                            break;
                        case 7:
                            hotelIMD.demandarServicosLimpeza(sc);
                            break;
                        case 8:
                            hotelIMD.demandarServicoRestaurante(sc);
                            break;
                        default:
                            break;
                    }                
                }
            } catch (InputMismatchException e) {
                System.out.println("\nOpção inválida! Error: " + e);
                break;
            }
        } while (opt != 0);
        sc.close();
    }
}
