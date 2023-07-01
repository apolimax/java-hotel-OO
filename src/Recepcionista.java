import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Recepcionista extends Funcionario {
    public Recepcionista(String nome, byte idade, float salario, Date dataAdmissao) {
        super(nome, idade, salario, dataAdmissao);
        //TODO Auto-generated constructor stub
    }
    
    static public void fazerReserva(Scanner sc) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Digite o nome do potencial hóspede: ");
            String nomeCliente = sc.next();
            System.out.print("Digite a idade do potencial hóspede: ");
            byte idadeCliente = sc.nextByte();
            System.out.print("Digite a data de check in (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Digite a data de check out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());
            Random rand = new Random();
            int newNumero = rand.nextInt(200);
            int newAndar = rand.nextInt(5);
            System.out.println("Digite o número correspondente ao tipo de quarto");
            System.out.println("1 para quarto de solteiro");
            System.out.println("2 para quarto duplo solteiro");
            System.out.println("3 para quarto de casal");
            int opt = sc.nextInt();
            Hospede novoHospede = null;

            switch (opt) {
                case 1:
                    QuartoSolteiro QuartoSolteiro = new QuartoSolteiro(newNumero, newAndar);
                    novoHospede = new Hospede(nomeCliente,idadeCliente, checkIn, checkOut, QuartoSolteiro);
                    break;
                case 2:
                    QuartoDuploSolteiro QuartoDuploSolteiro = new QuartoDuploSolteiro(newNumero, newAndar);
                    novoHospede = new Hospede(nomeCliente,idadeCliente, checkIn, checkOut, QuartoDuploSolteiro);
                    break;
                case 3:
                    QuartoCasal QuartoCasal = new QuartoCasal(newNumero, newAndar);
                    novoHospede = new Hospede(nomeCliente,idadeCliente, checkIn, checkOut, QuartoCasal);
                    break;
                default:
                    break;
            }

            if (novoHospede != null) {
                Hotel.hospedes.add(novoHospede);
                System.out.printf("A reserva para %s foi concluída com sucesso!", nomeCliente);
            }

        } catch (ParseException e) {
            System.out.println("Data inválida " + e);
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida " + e);
        } catch(IllegalArgumentException e) {
            System.out.println("Data de checkout deve ser posterior a data de check in!");
        }
    }

    static public void cancelarReserva(Scanner sc) {
        System.out.print("Digite o nome do hóspede: ");
        String nomeHospede = sc.next();
        Hospede hospede = null;

        for (Hospede h : Hotel.hospedes) {
            if (h.getNome().toLowerCase().equals(nomeHospede.toLowerCase())) {
                hospede = h;
            }
        }
        
        if (hospede == null) {
            System.out.println("Hóspede não encontrado");
        } else {
            Hotel.hospedes.remove(hospede);
            System.out.println("Reserva cancelada com sucesso");
        }
    }
}
