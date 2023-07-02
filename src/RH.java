import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RH extends Funcionario {
    public RH(String nome, byte idade, float salario, Date dataAdmissao) {
        super(nome, idade, salario, dataAdmissao);
        //TODO Auto-generated constructor stub
    }

    static public void contratarCandidato(Scanner sc) {
        try {
            System.out.print("Digite o nome do novo funcionário: ");
            String nomeFuncionario = sc.next();

            System.out.print("Digite o salário do novo funcionário: ");
            float salarioFuncionario = sc.nextFloat();

            System.out.print("Digite a idade do novo funcionário: ");
            byte idadeFuncionario = sc.nextByte();
            
            System.out.println(  "Digite o número correspondente ao departamento do novo funcionário"
                               + "\n1 para Recursos Humanos"
                               + "\n2 para Recepção"
                               + "\n3 para Restaurante"
                               + "\n4 para Limpeza");
            int departamento = sc.nextInt();
            
                switch (departamento) {
                    case 1:
                        RH rh = new RH(nomeFuncionario, idadeFuncionario, salarioFuncionario, new Date());            
                        Hotel.funcionarios.add(rh);
                        break;
                    case 2:
                        Recepcionista recepcionista = new Recepcionista(nomeFuncionario, idadeFuncionario, salarioFuncionario, new Date());            
                        Hotel.funcionarios.add(recepcionista);
                    break;
                    case 3:
                        Cozinheiro cozinheiro = new Cozinheiro(nomeFuncionario, idadeFuncionario, salarioFuncionario, new Date());            
                        Hotel.funcionarios.add(cozinheiro);
                    break;
                    case 4:
                        Camareira camareira = new Camareira(nomeFuncionario, idadeFuncionario, salarioFuncionario, new Date());            
                        Hotel.funcionarios.add(camareira);
                    break;
                    default:
                        break;
                }
        } catch (InputMismatchException e) {
            System.out.println("\nOpção inválida! Error: " + e);
        } 

        System.out.println("Funcionário contratado com sucesso!");
    }
    
    static public void demitirFuncionario(Scanner sc) {
        if (Hotel.funcionarios.isEmpty()) {
            System.out.println("A lista de funcionários está vazia");
            return;
        }

        try {
            System.out.print("Digite o nome do funcionário: ");
            String nomeFuncionario = sc.next();
            Funcionario f = null;
            
            for (Funcionario funcionario : Hotel.funcionarios) {
                if (funcionario.getNome().toLowerCase().equals(nomeFuncionario.toLowerCase())) {
                    f = funcionario;
                }
            }
            
            if (f == null) {
                System.out.println("Funcionário não encontrado");
            } else {
                Hotel.funcionarios.remove(f);
                System.out.println("Funcionário demitido com sucesso");
            }
        } catch (InputMismatchException e) {
            System.out.println("\nOpção inválida! Error: " + e);
        }
    }
    
}
