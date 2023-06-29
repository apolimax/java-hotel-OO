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
            System.out.println("Digite o nome do novo funcionário");
            String nomeFuncionario = sc.next();

            System.out.println("Digite o salário do novo funcionário");
            float salarioFuncionario = sc.nextFloat();

            System.out.println("Digite a idade do novo funcionário");
            byte idadeFuncionario = sc.nextByte();
            
            System.out.println("Digite o número correspondente ao departamento do novo funcionário");
            System.out.println("1 para Recursos Humanos");
            System.out.println("2 para Recepção");
            System.out.println("3 para Restaurante");
            System.out.println("4 para Limpeza");
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
            System.out.println("Opção inválida " + e);
        } 

        System.out.println("Funcionário contratado com sucesso");
    }
    
    static public void demitirFuncionario(Funcionario funcionario) {
        System.out.println("Demitindo o funcionario " + funcionario.getNome());
        // TODO: demitir funcionário a partir do seu nome
        Hotel.funcionarios.remove(funcionario);
    }
    
}
