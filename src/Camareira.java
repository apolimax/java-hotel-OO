import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Camareira extends Funcionario {
    public Camareira(String nome, byte idade, float salario, Date dataAdmissao) {
        super(nome, idade, salario, dataAdmissao);
        //TODO Auto-generated constructor stub
    }

    static public void solicitarLimpeza(Scanner sc) {
        try {        

            System.out.print("Digite o número do quarto: ");
            int numeroQuarto = sc.nextInt();

            System.out.println();

            boolean quartoExiste = false; 
            for (Quarto q : Hotel.quartos) {
                if (q.getNumero() == numeroQuarto) quartoExiste = true;
            }

            if (quartoExiste) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.print("Digite a data de agendamento (dd/MM/yyyy): ");
                Date data = sdf.parse(sc.next());

                System.out.println("Limpeza do quarto " + numeroQuarto + " agendada para o dia " + data + ".");
            } else {
                System.out.println("Quarto desocupado.");
            }

        } catch (ParseException | InputMismatchException | IllegalArgumentException e) {
            System.out.println("\nOpção inválida! Error: " + e);
        }
    }

    static public void cancelarLimpeza(Scanner sc) {
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = sc.nextInt();

        System.out.println();

        boolean quartoExiste = false; 
        for (Quarto q : Hotel.quartos) {
            if (q.getNumero() == numeroQuarto) {
                quartoExiste = true;
            }
        }

        if (quartoExiste) {
            System.out.println("Agendamento da limpeza do quarto " + numeroQuarto + " cancelado.");
        } else {
            System.out.println("Quarto desocupado.");
        }
    }
}
