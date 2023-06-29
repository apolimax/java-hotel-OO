import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            // TODO: escolha do quarto
            Random rand = new Random();
            int newNumero = rand.nextInt(200);
            int newAndar = rand.nextInt(5);
            Quarto quarto = new Quarto(newNumero, newAndar);
            Hospede novoHospede = new Hospede(nomeCliente,idadeCliente, checkIn, checkOut, quarto);
            Hotel.hospedes.add(novoHospede);
        } catch (ParseException e) {
            System.out.println("Data inválida " + e);
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
