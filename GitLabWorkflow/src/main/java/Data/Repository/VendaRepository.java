package Data.Repository;

import Model.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaRepository {

    private List<Venda> vendas = new ArrayList<>();

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }
}
