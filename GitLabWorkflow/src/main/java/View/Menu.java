package View;

import Controller.ClienteController;
import Model.Cliente;
import Model.Pagamento;
import Model.PagamentoCartaoCredito;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Scanner;

public class Menu {
    private ClienteController clienteController = new ClienteController();
    public Cliente cadastrarCliente(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("~~~~~~Cadastrando Cliente~~~~~~");
        System.out.print("Informe o nome: ");
        String nome = entrada.nextLine();
        String cpf;
        do {
            System.out.print("Informe o CPF: ");
            cpf = entrada.nextLine();
        }while (!ClienteController.verificarCpf(cpf));

        String email;
        do{
            System.out.print("Informe o e-mail: ");
            email = entrada.nextLine();

            if(!email.contains("@")){
                System.out.println("\nInforme um e-mail válido!\n");
            }

        }while (!email.contains("@"));

        System.out.print("Digite a senha: ");
        String senha = entrada.nextLine();
        Cliente cliente = new Cliente(nome, cpf, email, senha);
        clienteController.cadastrarCliente(cliente);

        System.out.println("\nCliente cadastrado com sucesso!");
        return cliente;
    }
    public void venderIngressos(Cliente cliente){
        Scanner entrada = new Scanner(System.in);
        //listar eventos

        System.out.println("Digite o número do evento desejado:\n");
        int escolha = entrada.nextInt();
        System.out.println("Digite a quantidade de ingressos:\n");
        int quantidade = entrada.nextInt();
        System.out.println("Qual a forma de pagamento:\n1 - Cartão de Crédito" );
        int opcao = entrada.nextInt();
        Pagamento pagamento;
        if(opcao==1){
            pagamento = new PagamentoCartaoCredito();
            pagamento.efetuarPagamento(0);
        }

    }


}
