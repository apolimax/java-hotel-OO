import java.util.Date;

public class Garçom extends Funcionario {
    public Garçom(float salario, Date dataAdmissao) {
        super(salario, dataAdmissao);
        //TODO Auto-generated constructor stub
    }

    public void atenderMesa(byte nMesa) {
        System.out.println("Atendendo a mesa " + nMesa);
    }
    
    public void anotarPedido(String pedido) {
        System.out.println("Anotando o pedido " + pedido);
    }
    
    public void entregarPedido(byte nMesa) {
        System.out.println("Entregando o pedido a mesa " + nMesa);
    }
    
}
