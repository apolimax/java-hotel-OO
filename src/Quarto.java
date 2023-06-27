public class Quarto {
    protected int numero;
    protected int andar;
    
    public int getNumero() {
        return numero;
    }

    public int getAndar() {
        return andar;
    }

    public Quarto(int numero, int andar) {
        this.numero = numero;
        this.andar = andar;
    }

    @Override
    public String toString() {
        return "Número: " + this.numero +
                "Andar: " + this.andar;
    }
}
