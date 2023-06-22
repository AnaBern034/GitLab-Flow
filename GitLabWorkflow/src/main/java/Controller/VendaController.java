package Controller;

import Data.Repository.VendaRepository;
import Model.*;

public class VendaController {
    private VendaRepository vendaRepository = new VendaRepository();
    public void vender(Cliente cliente, Evento evento, int quantidade, Pagamento pagamento){
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setIngresso(evento);
        venda.setPagamento(pagamento);
        venda.setQuantidade(quantidade);
        venda.setValorTotal(evento.getValor()*quantidade);
        vendaRepository.adicionarVenda(venda);
        System.out.println("--------------INGRESSO-----------------");
        System.out.println(venda.mostrarVenda());
        System.out.println("---------------------------------------");
    }
}
