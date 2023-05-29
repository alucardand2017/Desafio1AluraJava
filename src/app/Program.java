package app;

import domain.Cliente;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {

        int escolha = 0;
        Cliente c1 = new Cliente(1, "Anderson Silva", 12345, 54321, 2500);

        try {
            ExibiDadosCliente(c1);
            escolha = Menu();
            DirecionaOperacao(escolha, c1);
            ExibiDadosCliente(c1);
        }
        catch (Exception e) {
            System.out.println("Erro na programação: " + e.getMessage());
        }
    }
    private static void DirecionaOperacao(int escolha, Cliente c1) {
        Scanner entrada = new Scanner(System.in);
        double valor = 0f;
        switch (escolha) {
            case 1:
                System.out.println("Saldo atual: "+ c1.getSaldo());
                break;
            case 2:
                System.out.printf("Valor a tranferir: ");
                valor = entrada.nextDouble();
                c1.Transferir(valor);
                break;
            case 3:
                System.out.printf("Valor a depositar: ");
                valor = entrada.nextDouble();
                c1.Depositar(valor);
                break;
            case 4:
                System.out.printf("Valor a Sacar: ");
                valor = entrada.nextDouble();
                c1.Sacar(valor);
                break;
            case 5:
                System.out.println("Saindo do programa!");
                break;
            default:
                System.out.println("Escolheu algo errado!!!");
        }
    }
    private static int Menu() throws Exception {
        Scanner entradaTecladoNumerico = new Scanner(System.in);
        String menuTela = """
                *************************
                Digite a opção desejada:*
                                        *
                1) Ver saldo            *
                2) Transferir valor     *
                3) Depositar valor      *
                4) Sacar valor          *
                5) Sair                 *
                *************************
                * opção: 
                """;
        System.out.println(menuTela);
        int escolha = entradaTecladoNumerico.nextInt();
        if (escolha > 5 || escolha < 0) {
            throw  new Exception("Argumento inválido");
        }
        return escolha;
    }
    private static void ExibiDadosCliente(@org.jetbrains.annotations.NotNull Cliente c1) {
        String dadosCliente =
                """
                        Cliente N:  %d
                        Nome:       %S
                        Agencia:    %d
                        Conta:      %d
                        Saldo:      %.2f
                        """;
        System.out.println(String.format(dadosCliente, c1.getId(), c1.getNome(), c1.getAgencia(), c1.getConta(), c1.getSaldo()));
    }
    private static void FuncionalidadesDeUmaString() {
        String tenisDeMesa = """
                
                Substantivo masculino Esporte. Jogo parecido com o tênis, 
                disputado sobre uma mesa dividida ao meio por uma rede, 
                em que se usam raquetes e uma bola de celuloide; pingue-pongue.
                
                """;
        System.out.println("Texto para análise:" + tenisDeMesa);

        System.out.println(tenisDeMesa.contains("tênis"));
        System.out.println(tenisDeMesa.indexOf(10));
        System.out.println(tenisDeMesa.indexOf("dividida"));
        System.out.println(tenisDeMesa.toUpperCase());
        System.out.println(tenisDeMesa.hashCode());
        System.out.println(tenisDeMesa.codePointAt(1));
        System.out.println(tenisDeMesa.codePointBefore(1));
        System.out.println(tenisDeMesa.codePointCount(0,10));
        System.out.println(tenisDeMesa.length());
        System.out.println(tenisDeMesa.contentEquals("disputado"));
    }
    private static void RecebeNotasEMostraMedia() {
        Scanner entrada = new Scanner(System.in);
        double[] notas = new double[4];
        System.out.println("\nAgora, digite suas notas:");
        System.out.println("P1 = ");
        notas[0] = entrada.nextDouble();
        System.out.println("P2 = ");
        notas[1] = entrada.nextDouble();
        System.out.println("P3 = ");
        notas[2]= entrada.nextDouble();
        notas[3] = (notas[0]+ notas[1]+ notas[2])/(notas.length-1);
        System.out.println(String.format("""
                
                Boletim
                P1 = %.2f
                P2 = %.2f
                P3 = %.2f
                Média Final = %.2f
                """, notas[0], notas[1], notas[2], notas[3]));
    }
    private static void EntradasDeTexto() {
        Scanner entrada = new Scanner(System.in);
        String explicacao = """
                Programa para testar as entradas do Scanner:
                
                Inicie digitando um texto: """;
        System.out.println(explicacao);
        String texto = entrada.nextLine();
        System.out.println("agora digite um inteiro: ");
        int inteiro = entrada.nextInt();
        System.out.println("agora, digite um numero fracionado:");
        double fracionado = entrada.nextDouble();
        System.out.println("agora, digite um booleado 0 ou 1");
        boolean binario = entrada.nextBoolean();
        System.out.println(String.format("""             
                texto = %S
                inteiro = %d
                fracionado = %.2f
                binario =  %b""",texto, inteiro, fracionado,binario));
    }

}
