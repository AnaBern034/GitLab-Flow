package View;

import Controller.ClienteController;
import Controller.EventoController;
import Controller.VendaController;
import Model.Cliente;
import Model.Evento;
import Model.Pagamento;
import Model.PagamentoCartaoCredito;

import java.util.Scanner;

public class Menu {
    private ClienteController clienteController = new ClienteController();
    private EventoController eventoController = new EventoController();
    private VendaController vendaController = new VendaController();
    private  Scanner entrada = new Scanner(System.in);
    public Cliente cadastrarCliente(){
        System.out.println("~~~~~~Cadastrando Cliente~~~~~~");
        System.out.print("Informe o nome: ");
        String nome = EntradasView.verificaBufferScaner(entrada.nextLine());
        String cpf = EntradasView.lerCPF();
        String email = EntradasView.lerEmail();

        System.out.print("Digite a senha: ");
        String senha = entrada.next();
        Cliente cliente = new Cliente(nome, cpf, email, senha);
        clienteController.cadastrarCliente(cliente);

        System.out.println("\nCliente cadastrado com sucesso!");
        return cliente;
    }
    public void venderIngressos(Cliente cliente){
        System.out.println("BEM VINDO "+cliente.getNome()+"!Escolha seu evento e aproveite:)");
        eventoController.exibirEventosDisponiveis();
        System.out.print("\nDigite o número do evento desejado: ");

        int escolha = entrada.nextInt();
        Evento evento = eventoController.buscarEvento(escolha);

        System.out.print("Digite a quantidade de ingressos: ");
        int quantidade = entrada.nextInt();

        System.out.println("Qual a forma de pagamento:\n1 - Cartão de Crédito" );
        int opcao = entrada.nextInt();
        Pagamento pagamento;
        if(opcao==1){
            pagamento = pagamentoCredito();
            pagamento.efetuarPagamento(evento.getValor()*quantidade);
            vendaController.vender(cliente,evento,quantidade,pagamento);
        }

    }

    public Cliente login(){
        String email = EntradasView.lerEmail();
        System.out.print("Digite sua senha: ");
        String senha = entrada.next();
        return clienteController.login(email,senha);
    }

    public Pagamento pagamentoCredito(){
        System.out.println("Insira o numero do cartão:");
        String numeroCartao = entrada.next();
        System.out.println("Insira o seu CVV:");
        int cvv = entrada.nextInt();
        return new PagamentoCartaoCredito(numeroCartao,cvv);
    }

}
