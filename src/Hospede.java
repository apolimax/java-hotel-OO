import java.util.Date;

public class Hospede extends Pessoa {
    private Reserva reserva;
    
    public Reserva getReserva() {
        return reserva;
    }

    public Hospede(String nome, byte idade, Date checkIn, Date checkOut, Quarto quarto) throws IllegalArgumentException {
        super(nome, idade);
        
        if (!checkOut.after(checkIn)){
            throw new IllegalArgumentException("Data de checkout deve ser posterior a data de check in!");
        } else {
            this.reserva = new Reserva(quarto, checkIn, checkOut);
        }

    }
}
