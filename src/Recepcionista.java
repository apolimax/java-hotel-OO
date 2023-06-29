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

    public void atenderCliente(Pessoa cliente) {
        System.out.println("Atendendo o cliente " + cliente.getNome());
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("---- Digite o que deseja fazer ---- ");
        System.out.println("Digite 1 para fazer uma nova reserva");
        System.out.println("Digite 2 para cancelar uma reserva");
        System.out.println("Digite 3 para sair");

        try {
            int digito = sc.nextInt();
    
            switch (digito) {
                case 1:
                    System.out.print("Digite o nome do potencial hóspede: ");
                    String nomeCliente = sc.nextLine();
                    System.out.print("Digite a idade do potencial hóspede: ");
                    byte idadeCliente = sc.nextByte();
                    System.out.print("Digite a data de check in (dd/MM/yyyy): ");
                    Date checkIn = sdf.parse(sc.next());
                    System.out.print("Digite a data de check out (dd/MM/yyyy): ");
                    Date checkOut = sdf.parse(sc.next());
                    fazerReserva(nomeCliente, idadeCliente, checkIn, checkOut);
                    break;
                case 2:
                    System.out.print("Digite o nome do hóspede: ");
                    String nomeHospede = sc.nextLine();
                    cancelarReserva(nomeHospede);
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida " + e);
        } catch (ParseException e) {
            System.out.println("Data inválida " + e);
        } finally {
            sc.close();
        }


    }
    
    public void fazerReserva(String nomeCliente, byte idadeCliente, Date checkIn, Date checkOut) {
        System.out.println("Fazendo a reserva para o cliente " + nomeCliente);
        Random rand = new Random();
        int newNumero = rand.nextInt(200);
        int newAndar = rand.nextInt(5);
        Quarto quarto = new Quarto(newNumero, newAndar);
        Hospede novoHospede = new Hospede(nomeCliente,idadeCliente ,checkIn, checkOut, quarto);
        Hotel.hospedes.add(novoHospede);
    }

    public void cancelarReserva(String nomeHospede) {
        System.out.println("Cancelando a reserva para o hóspede " + nomeHospede);
        Hospede hospede = null;
        for (Hospede h : Hotel.hospedes) {
            if (h.getNome() == nomeHospede) {
                hospede = h;
                Hotel.hospedes.remove(hospede);
            }
        }

        if (hospede == null) {
            System.out.println("Hóspede não encontrado");
        }
    }
}
