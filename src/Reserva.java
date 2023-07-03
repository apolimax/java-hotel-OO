import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Quarto quarto;
    private Date checkIn;
    private Date checkOut;

    public Reserva(Quarto quarto, Date checkIn, Date checkOut) {
        this.quarto = quarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    
    public Date getCheckIn() {
        return checkIn;
    }
    
    public Date getCheckOut() {
        return checkOut;
    }

    public Quarto getQuarto() {
        //return quarto.toString();
        return quarto;
    }

    public long getDuracao() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
