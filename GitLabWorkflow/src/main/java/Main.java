import Model.Cliente;
import View.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Menu menu = new Menu();
        Cliente cliente;

        while (true){
            System.out.println("\n----------- SISTEMA DE VENDAS DE EVENTOS -----------");
            System.out.println("""
                    \t1 - Login
                    \t2 - Cadastrar
                    \t3 - Sair
                    """);

            try {
                switch (entrada.nextInt()){
                    case 1:
                        cliente = menu.login();
                        menu.venderIngressos(cliente);
                        break;
                    case 2:
                        cliente = menu.cadastrarCliente();
                        menu.venderIngressos(cliente);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        throw new IllegalArgumentException("Opcão inválida!");
                }
            } catch (IllegalArgumentException erro){
                System.err.println(erro.getMessage());
            }
        }
    }
}
