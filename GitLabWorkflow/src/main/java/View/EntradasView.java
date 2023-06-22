package View;

import Controller.ClienteController;

import java.util.Scanner;

public class EntradasView {
    private static Scanner entrada = new Scanner(System.in);
    public static String lerEmail(){
        String email;
        do{
            System.out.print("Digite seu e-mail: ");
            email = entrada.next();

            if(!email.contains("@")){
                System.out.println("\nInforme um e-mail válido!\n");
            }

        }while (!email.contains("@"));

        return email;
    }
    public static String lerCPF(){
        String cpf;
        do {
            System.out.print("Informe o CPF: ");
            cpf = entrada.next();
        }while (!ClienteController.verificarCpf(cpf));
        return cpf;
    }
    public static String verificaBufferScaner(String entrada){
        if (entrada.isEmpty()){
            Scanner sc = new Scanner(System.in);
            entrada =sc.nextLine();

        }
        return entrada;
    }
}
