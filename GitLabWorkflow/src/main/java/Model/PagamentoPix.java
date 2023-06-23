package Model;

import java.util.UUID;

public class PagamentoPix implements Pagamento{

    private double preco;


    public PagamentoPix() {
    }

    @Override
    public void efetuarPagamento(double valor) {
        System.out.println("Chave aleatória para Pix: ");
        System.out.println(UUID.randomUUID());
        preco = valor * (-0.05);
    }

    @Override
    public double getPreco() {
        return preco;
    }

}
