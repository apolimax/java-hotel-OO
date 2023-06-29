import java.util.Date;

public class Hospede extends Pessoa {
    //private String hotelHospedado;
    /* private Byte nQuartoHospedado;
    private Float custoHospedagem; */
    /* private Quarto quarto;
    private Date checkin;
    private Date checkout; */
    private Reserva reserva;
    
    public Reserva getReserva() {
        return reserva;
    }

    public Hospede(String nome, byte idade, Date checkIn, Date checkOut, Quarto quarto) throws IllegalArgumentException {
        //this.hotelHospedado = hotelHospedado;
        /* this.checkin = checkin;
        this.checkout = checkout;
        this.quarto = quarto; */
        super(nome, idade);
        
        if (!checkOut.after(checkIn)){
            throw new IllegalArgumentException("Data de checkout deve ser posterior a data de check in");
        } else {
            this.reserva = new Reserva(quarto, checkIn, checkOut);
        }

    }

    public void fazerReserva() {}

    public void cancelarReserva() {
        this.reserva = null;
        Hotel.hospedes.remove(this);
    }
}
