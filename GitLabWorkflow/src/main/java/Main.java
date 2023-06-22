import View.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Menu menu = new Menu();

        while (true){
            System.out.println("\n----------- SISTEMA DE VENDAS DE EVENTOS -----------");
            System.out.println("""
                    \t1 - Login
                    \t2 - Cadastrar
                    \t3 - Sair
                    """);

            try {
                switch (entrada.nextInt()) {
                    case 1 -> menu.venderIngressos(menu.login());
                    case 2 -> menu.venderIngressos(menu.cadastrarCliente());
                    case 3 -> System.exit(0);
                    default -> throw new IllegalArgumentException("Opcão inválida!");
                }
            } catch (IllegalArgumentException erro){
                System.err.println(erro.getMessage());
            }
        }
    }

}
