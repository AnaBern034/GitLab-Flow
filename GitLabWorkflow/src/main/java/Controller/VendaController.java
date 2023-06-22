package Controller;

import Data.Repository.VendaRepository;
import Model.Cliente;
import Model.Evento;
import Model.Venda;

public class VendaController {
    private VendaRepository vendaRepository = new VendaRepository();
    public void vender(Cliente cliente, Evento evento, int quantidade){
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setIngresso(evento);

        venda.setQuantidade(quantidade);
        venda.setValorTotal(evento.getValor()*quantidade);
        vendaRepository.adicionarVenda(venda);
    }
}
