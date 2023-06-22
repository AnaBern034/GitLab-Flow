package View;

import Controller.ClienteController;
import Data.Repository.ClienteRepository;
import Data.Repository.EventoRepository;
import Model.Cliente;
import Model.Evento;
import Model.Pagamento;
import Model.PagamentoCartaoCredito;

import java.util.Scanner;

public class Menu {
    private ClienteController clienteController = new ClienteController();
    private ClienteRepository clienteRepository = new ClienteRepository();
    private EventoRepository eventoRepository = new EventoRepository();
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
        eventoRepository.listarEventos();
        System.out.print("\nDigite o número do evento desejado: ");
        int escolha = entrada.nextInt();
        Evento evento = eventoRepository.retornarEvento(escolha);
        System.out.print("Digite a quantidade de ingressos: ");
        int quantidade = entrada.nextInt();
        System.out.println("Qual a forma de pagamento:\n1 - Cartão de Crédito" );
        int opcao = entrada.nextInt();
        Pagamento pagamento;
        if(opcao==1){
            pagamento = new PagamentoCartaoCredito();
            pagamento.efetuarPagamento(evento.getValor()*quantidade);
        }

    }

    public Cliente login(){
        Scanner entrada = new Scanner(System.in);

        String email;
        do{
            System.out.print("Digite seu e-mail: ");
            email = entrada.nextLine();

            if(!email.contains("@")){
                System.out.println("\nInforme um e-mail válido!\n");
            }

        }while (!email.contains("@"));

        System.out.print("Digite sua senha: ");
        String senha = entrada.next();

        if(clienteRepository.procuraClienteEmail(email, senha) == null){
            throw new IllegalArgumentException("Cliente não cadastrado");
        }
        return clienteRepository.procuraClienteEmail(email, senha);
    }
}
