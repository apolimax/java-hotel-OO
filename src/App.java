import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Hotel hotelIMD = new Hotel();

        int opt = 1;
        do {
            try {
                System.out.println();
                System.out.println("--- Bem-vindo ao sistema de reservas do Hotel IMD ---");
                System.out.println("Digite 1 para listar funcionários");
                System.out.println("Digite 2 para listar dados de um funcionário pelo seu nome");
                System.out.println("Digite 3 para listar hóspedes");
                System.out.println("Digite 4 para listar dados de um hóspede pelo seu nome");
                System.out.println("Digite 5 para demandar serviços de recursos humanos");
                System.out.println("Digite 6 para demandar serviços de recepção");
                System.out.println("Digite 7 para demandar serviços de limpeza de quarto");
                System.out.println("Digite 8 para demandar serviços de restaurante");
                System.out.println("Digite 9 para finalizar o programa");
                opt = sc.nextInt();

                switch (opt) {
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
                    default:
                        break;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida " + e);
                opt = 9;
            }
        } while (opt != 9);




        sc.close();
    }
}
